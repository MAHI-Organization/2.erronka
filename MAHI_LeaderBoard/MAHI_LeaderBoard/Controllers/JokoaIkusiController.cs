using MAHI_LeaderBoard.Models;
using MAHI_LeaderBoard.Services;
using MAHI_LeaderBoard.ViewModels;
using Microsoft.AspNetCore.Mvc;

namespace MAHI_LeaderBoard.Controllers
{
    public class JokoaIkusiController : Controller
    {
        private readonly IKomentarioaService _komentarioaService;
        private readonly IBalorazioaService _balorazioaService;

        public JokoaIkusiController(IKomentarioaService komentarioaService,IBalorazioaService balorazioaService)
        {
            _komentarioaService = komentarioaService;
            _balorazioaService = balorazioaService;
        }

        public async Task<IActionResult> Index(int id)
        {
            var jokoaVM = new JokoaViewModel();
            System.Diagnostics.Debug.WriteLine("ID: " + id);
            List<Komentarioa> komentarioGuztiak = new List<Komentarioa>();
            List<Balorazioa> jokoarenBalorazioak = new List<Balorazioa>();
            float batazBestekoBalorazioa;
            string jokoarenIzena = "";
            if(id == 1)
            {
                jokoarenIzena = "MAHI";
            }else if(id == 2)
            {
                jokoarenIzena = "Johnny";
            }else if (id == 3)
            {
                jokoarenIzena = "Pouni";
            }else if(id == 4)
            {
                jokoarenIzena = "Jokoa4";
            }

            komentarioGuztiak = await _komentarioaService.GetJokoarenKomentarioak(jokoarenIzena);
            batazBestekoBalorazioa = await _balorazioaService.GetBatazBestekoBalorazioa(jokoarenIzena);
            jokoarenBalorazioak = await _balorazioaService.GetJokoarenBalorazioak(jokoarenIzena);
            jokoaVM.BatazBestekoBalorazioa = batazBestekoBalorazioa;
            jokoaVM.JokoaIzena = jokoarenIzena;
            jokoaVM.KomentarioaVMList = komentarioGuztiak;
            jokoaVM.BalorazioakVMList = jokoarenBalorazioak;

            return View(jokoaVM);
        }
    }
}
