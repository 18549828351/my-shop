using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace WebApp.Models
{
    public class User
    {
        [Key]        
        public string UserID { get; set; }
        public string UserName { get; set; }
        public string Password { get; set; }
    }
}
