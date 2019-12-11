using System;
using System.Threading;

namespace ConsoleApp1
{
    class Program
    {
        static void Main(string[] args)
        {
            while (true)
            {
                Thread.Sleep(1000);
                Console.WriteLine(DateTime.Now.ToString("yyyyMMddHHmmssffffff"));
            }
        }
    }
}
