using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using WebApp.Models;
using WebApp.Repository;

namespace WebApp.Controllers
{
    public class HomeController : Controller
    {
        private RoleRepository roleRepository=new RoleRepository();
        //private RoleRepository roleRepository = new RoleRepository();
        public IActionResult Index()
        {
            return View();
        }

        public string Get()
        {
            // roleRepository.Connection.BeginTransaction();
            List<Role> roles = roleRepository.find("");
            roles[0].Remark = "aaa";
            roles[0].RoleName = "aaa";
            roles[1].Remark = "bbb";
            roles.Add(new Role("123"));
            return roleRepository.saveOrUpdateAll(roles);
        }


        public string saveOrUpdateAll()
        {
            // roleRepository.Connection.BeginTransaction();
            List<Role> roles = roleRepository.find("");
            roles[0].Remark = "aaa";
            roles[0].RoleName = "aaa";
            roles[1].Remark = "bbb";
            roles.Add(new Role("123"));
            return roleRepository.saveOrUpdateAll(roles);
        }

        public string deleteAll()
        {
            // roleRepository.Connection.BeginTransaction();
            List<Role> roles = new List<Role>();
            roles.Add(new Role("111"));
            roles.Add(new Role("222"));
            roles.Add(new Role("333"));
            roles.Add(new Role("444"));
            roles.Add(new Role("555"));
            return roleRepository.deleteAll(roles);
        }

        public string saveAll()
        {
            // roleRepository.Connection.BeginTransaction();
            List<Role> roles = new List<Role>();
            roles.Add(new Role("111"));
            roles.Add(new Role("222"));
            roles.Add(new Role("333"));
            roles.Add(new Role("444"));
            roles.Add(new Role("555"));
            return roleRepository.saveAll(roles);
        }
        public string Set()
        {
            Role role = new Role();
            role.RoleID = "qazz";

            string bbb = "";// roleRepository.Add(role);
            return bbb;
        }

        public IActionResult About()
        {
            ViewData["Message"] = "Your application description page.";

            return View();
        }

        public IActionResult Contact()
        {
            ViewData["Message"] = "Your contact page.";

            return View();
        }

        public IActionResult Privacy()
        {
            return View();
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}
