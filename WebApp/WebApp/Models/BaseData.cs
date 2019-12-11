using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace WebApp.Models
{
    public class BaseData
    {

        /// <summary>
        /// 基础数据关联类型，比如user用户相关，Modeler建模相关    
        /// </summary>
        [Key]
        public string DataCate { get; set; }

        /// <summary>
        /// K    
        /// </summary>
        [Key]
        public string DataKey { get; set; }

        /// <summary>
        /// V1    
        /// </summary>
        public string Value1 { get; set; }

        /// <summary>
        /// V2    
        /// </summary>
        public string value2 { get; set; }

        /// <summary>
        /// V3    
        /// </summary>
        public string Value3 { get; set; }

        public BaseData()
        { }

        public BaseData(string Cate,string Key)
        {
            this.DataCate = Cate;
            this.DataKey = Key;
        }
    }
}
