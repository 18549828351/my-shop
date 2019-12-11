using Dapper;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;
using WebApp.Models;

namespace WebApp.Repository
{
    public class Repository<T>
    {

        //IDbTransaction transaction = dbConnection.BeginTransaction();

        //transaction.Commit();
        //transaction.Rollback();

        /// <summary>
        /// 配置连接信息并创建连接
        /// </summary>
        private string connectionString = @"server =192.168.3.41; uid = sa; pwd = admin@123; database = TEST1;";       
        public IDbConnection Connection
        {
            get
            {
                return new SqlConnection(connectionString);
            }
        }

        /// <summary>
        /// 根据条件查找 hql为条件字符串，为空则查询所有，
        /// </summary>
        /// <param name="hql">不用写select和where，直接写条件，可为空，格式： and aa="aaa" and bb="bbb"</param>
        /// <returns></returns>
        public List<T> find(string hql)
        {
            using (IDbConnection dbConnection = Connection)
            {
                dbConnection.Open();
                string sql = "SELECT * FROM " + getClassType() + " Where 1=1 " + hql;
                IEnumerable<T> lt = dbConnection.Query<T>(sql);
                if (lt.Any<T>())
                {
                    return dbConnection.Query<T>(sql).ToList();
                }
                else
                {
                    return null;
                }
            }
        }

        /// <summary>
        /// 根据主键获取数据，其他字段忽略，
        /// </summary>
        /// <param name="t"></param>
        /// <returns></returns>
        public T findById(T t)
        {
            using (IDbConnection dbConnection = Connection)
            {
                dbConnection.Open();
                string sql = "SELECT * FROM " + getClassType() + " where "+getKeyString(t);
                return dbConnection.Query<T>(sql,t).FirstOrDefault();
            }
        }

        /// <summary>
        /// 删除一条数据，byKey
        /// </summary>
        /// <param name="t"></param>
        /// <returns></returns>
        public string delete(T t)
        {
            try
            {
                using (IDbConnection dbConnection = Connection)
                {
                    string sQuery = "DELETE FROM " + getClassType() + " where " + getKeyString(t);
                    dbConnection.Open();
                    dbConnection.Execute(sQuery,t);
                }
                return "0000";
            }
            catch (Exception e)
            {
                return e.ToString();
            }            
        }

        /// <summary>
        /// 删除List中所有数据
        /// </summary>
        /// <param name="lt"></param>
        /// <returns></returns>
        public string deleteAll(List<T> lt)
        {
            foreach (T t in lt)
            {
                string temp = delete(t);
                if (!"0000".Equals(temp))
                {
                    return temp;
                }
            }
            return "0000";
        }

        /// <summary>
        /// 新增一条数据
        /// </summary>
        /// <param name="t"></param>
        /// <returns></returns>
        public string save(T t)
        {
            try
            {
                using (IDbConnection dbConnection = Connection)
                {                   
                    string sQuery = "INSERT INTO " + getClassType() + getKeyList("", t)
                                    + " VALUES" + getKeyList("@", t);
                    dbConnection.Open();
                    dbConnection.Execute(sQuery, t);
                }
                return "0000";
            }
            catch (Exception e)
            {
                return e.ToString();
            }
        }

        /// <summary>
        /// 保存所有数据
        /// </summary>
        /// <param name="lt"></param>
        /// <returns></returns>
        public string saveAll(List<T> lt)
        {
            foreach (T t in lt)
            {
                string temp = save(t);

                if (!"0000".Equals(temp))
                {
                    return temp;
                }
            }
            return "0000";
        }

        /// <summary>
        /// 更新一条数据
        /// </summary>
        /// <param name="t"></param>
        /// <returns></returns>
        public string update(T t)
        {
            try
            {
                using (IDbConnection dbConnection = Connection)
                {
                    string sQuery = "UPDATE " + getClassType() +" SET "+ getColumString(t)
                                    + " WHERE " + getKeyString(t);
                    dbConnection.Open();
                    dbConnection.Execute(sQuery, t);
                }
                return "0000";
            }
            catch (Exception e)
            {
                return e.ToString();
            }
        }

        /// <summary>
        /// 更新所有数据
        /// </summary>
        /// <param name="lt"></param>
        /// <returns></returns>
        public string updateAll(List<T> lt)
        {
            foreach (T t in lt)
            {
                string temp = update(t);

                if (!"0000".Equals(temp))
                {
                    return temp;
                }
            }
            return "0000";
        }

        /// <summary>
        /// 有则修改，无则创建
        /// </summary>
        /// <param name="t"></param>
        /// <returns></returns>
        public string saveOrUpdate(T t)
        {
            T t1;
            try
            {
                t1 = findById(t);
                if (t1 == null)
                {
                    return save(t);
                }
                else
                {
                    return update(t);
                }
            }
            catch (Exception e)
            {
                return save(t);
            }
        }

        /// <summary>
        /// 更新所有数据
        /// </summary>
        /// <param name="lt"></param>
        /// <returns></returns>
        public string saveOrUpdateAll(List<T> lt)
        {
            foreach (T t in lt)
            {
                string temp = saveOrUpdate(t);

                if (!"0000".Equals(temp))
                {
                    return temp;
                }
            }
            return "0000";
        }





        #region toolFunction

        /// <summary>
        /// 获取主键字符串 格式 " @key1=key1 and @key2=key2"
        /// </summary>
        /// <param name="t"></param>
        /// <returns></returns>
        private string getKeyString(T t)
        {
            StringBuilder sb = new StringBuilder();
            PropertyInfo[] properties = t.GetType().GetProperties();

            sb.Append(" 1=1 ");
            
            foreach (var item in properties)
            {
                object[] aaa = item.GetCustomAttributes(false);
                foreach (var attri in aaa)
                {
                    if (attri is KeyAttribute)
                    {
                        sb.Append(" and @"+item.Name+"="+item.Name);  
                        break;
                    }                    
                }                
            }
            return sb.ToString();
        }

        /// <summary>
        /// 获取主键外字段字符串 格式 " set @key1=key1 ， @key2=key2" update用
        /// </summary>
        /// <param name="t"></param>
        /// <returns></returns>
        private string getColumString(T t)
        {
            StringBuilder sb = new StringBuilder();
            PropertyInfo[] properties = t.GetType().GetProperties();

            sb.Append(" ");
          
            foreach (var item in properties)
            {
                bool isKey = false;
                object[] aaa = item.GetCustomAttributes(false);
                foreach (var attri in aaa)
                {
                    if (attri is KeyAttribute)
                    {
                        isKey = true;
                        break;
                    }                    
                }
                if (!isKey)
                {
                    sb.Append(" " + item.Name + "= @" + item.Name);                    
                    sb.Append(" ,");                    
                }
            }
            string st = sb.ToString();
            //sb.Remove(sb.Length - 1, 1);
            return st.Substring(0,st.Length-1);
        }

        /// <summary>
        /// 获取数据类型
        /// </summary>
        /// <returns></returns>
        private string getClassType()
        {
            string[] key = typeof(T).ToString().Split(".");
            return key[key.Length - 1];
        }
         /// <summary>
         /// 获取字段列表并用（）包裹，逗号隔开
         /// </summary>
         /// <param name="a">追加固定前缀</param>
         /// <param name="t">Entity</param>
         /// <returns>(a+K1,a+K2,a+K3......)</returns>
        private string getKeyList(string a, T t)
        {
           
            
            StringBuilder sb = new StringBuilder();
            PropertyInfo[] properties = t.GetType().GetProperties();
            
            sb.Append("(");
            int i = 1;
            foreach (var item in properties)
            {
                object[] aaa=item.GetCustomAttributes(false);
                sb.Append(a + item.Name);
                if (i < properties.Length)
                    sb.Append(",");
                i++;
            }
            sb.Append(")");
            return sb.ToString();
        }

       
        #endregion
    }
}
