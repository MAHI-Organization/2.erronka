using MAHI_LeaderBoard.Models;
using MAHI_LeaderBoard.Services;
using MAHI_LeaderBoard.ViewModels;
using Microsoft.AspNetCore.Mvc;

namespace MAHI_LeaderBoard.Controllers
{
    public class JokoaIkusiController : Controller
    {
        private readonly IKomentarioaService _komentarioaService;

        public JokoaIkusiController(IKomentarioaService komentarioaService)
        {
            _komentarioaService = komentarioaService;
        }

        public async Task<IActionResult> Index(int id)
        {
            var jokoaVM = new JokoaViewModel();
            System.Diagnostics.Debug.WriteLine("ID: " + id);
            List<Komentarioa> komentarioGuztiak = new List<Komentarioa>();
            string jokoarenIzena = "";
            if(id == 1)
            {
                jokoarenIzena = "MAHI";
            }else if(id == 2)
            {
                jokoarenIzena = "Johnny";
            }
            komentarioGuztiak = await _komentarioaService.GetJokoarenKomentarioak(jokoarenIzena);
            jokoaVM.KomentarioaVMList = komentarioGuztiak;

            return View(jokoaVM);
        }
    }
}
