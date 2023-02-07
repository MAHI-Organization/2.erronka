using Microsoft.AspNetCore.Mvc;

namespace MAHI_LeaderBoard.Controllers
{
    public class FirstGameController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }
    }
}
