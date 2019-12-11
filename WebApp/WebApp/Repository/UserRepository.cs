using Dapper;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Threading.Tasks;
using WebApp.Models;

namespace WebApp.Repository
{
    public class UserRepository
    {
        private string connectionString;
        public UserRepository()
        {
            //connectionString = @"Server=192.168.3.41;Database=TEST1;Trusted_Connection=true;ID = sa;Password = admin@123";
            connectionString = @"server =192.168.3.41; uid = sa; pwd = admin@123; database = TEST1;";//  providerName = System.Data.SqlClient";
        }

        public IDbConnection Connection
        {
            get
            {
                return new SqlConnection(connectionString);
            }
        }

        public void Add(User prod)
        {
            using (IDbConnection dbConnection = Connection)
            {
                string sQuery = "INSERT INTO User (UserID, UserName, Password)"
                                + " VALUES(@UserID, @UserName, @Password)";
                dbConnection.Open();
                dbConnection.Execute(sQuery, prod);
            }
        }

        public IEnumerable<User> GetAll()
        {
            using (IDbConnection dbConnection = Connection)
            {
                dbConnection.Open();
                return dbConnection.Query<User>("SELECT * FROM User");
            }
        }

        public User GetByID(int id)
        {
            using (IDbConnection dbConnection = Connection)
            {
                string sQuery = "SELECT * FROM User"
                               + " WHERE UserID = @Id";
                dbConnection.Open();
                return dbConnection.Query<User>(sQuery, new { Id = id }).FirstOrDefault();
            }
        }

        public void Delete(int id)
        {
            using (IDbConnection dbConnection = Connection)
            {
                string sQuery = "DELETE FROM User"
                             + " WHERE UserID = @Id";
                dbConnection.Open();
                dbConnection.Execute(sQuery, new { Id = id });
            }
        }

        public void Update(User prod)
        {
            using (IDbConnection dbConnection = Connection)
            {
                string sQuery = "UPDATE User SET UserName = @UserName,"
                               + " Password = @Password"
                               + " WHERE UserID = @UserID";
                dbConnection.Open();
                dbConnection.Query(sQuery, prod); 
            }
        }
    }
}
