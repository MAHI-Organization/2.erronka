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
        private readonly IPartidaService _partidaService;

        public JokoaIkusiController(IKomentarioaService komentarioaService,IBalorazioaService balorazioaService, IPartidaService partidaService)
        {
            _komentarioaService = komentarioaService;
            _balorazioaService = balorazioaService;
            _partidaService = partidaService;
        }

        public async Task<IActionResult> Index(int id)
        {
            var jokoaVM = new JokoaViewModel();
            System.Diagnostics.Debug.WriteLine("ID: " + id);
            List<Komentarioa> komentarioGuztiak = new List<Komentarioa>();
            List<Balorazioa> jokoarenBalorazioak = new List<Balorazioa>();
            List<Partida> partidaGuztiak = new List<Partida>();
            string rutaPartidak = "";
            float batazBestekoBalorazioa;
            string jokoarenIzena = "";
            if(id == 1)
            {
                jokoarenIzena = "MahiKingdom";
                rutaPartidak = "http://192.168.65.14:8080/partidak/partidaGuztiak";
            }
            else if(id == 2)
            {
                jokoarenIzena = "Johnny";
                rutaPartidak = "http://192.168.65.90:8081/demo/all_Partida";
            }
            else if (id == 3)
            {
                jokoarenIzena = "Pouni";
                rutaPartidak = "http://192.168.65.12:8080/demo/get";
            }
            else if(id == 4)
            {
                jokoarenIzena = "Zombie Killer";
                rutaPartidak = "http://192.168.65.90:8081/demo/all_Partida";
            }

            komentarioGuztiak = await _komentarioaService.GetJokoarenKomentarioak(jokoarenIzena);
            batazBestekoBalorazioa = await _balorazioaService.GetBatazBestekoBalorazioa(jokoarenIzena);
            jokoarenBalorazioak = await _balorazioaService.GetJokoarenBalorazioak(jokoarenIzena);
            partidaGuztiak = await _partidaService.GetJokoarenPartidak(rutaPartidak);

            jokoaVM.BatazBestekoBalorazioa = batazBestekoBalorazioa;
            jokoaVM.JokoaIzena = jokoarenIzena;
            jokoaVM.KomentarioaVMList = komentarioGuztiak;
            jokoaVM.BalorazioakVMList = jokoarenBalorazioak;
            jokoaVM.PartidaVMList = partidaGuztiak;

            return View(jokoaVM);
        }
    }
}
