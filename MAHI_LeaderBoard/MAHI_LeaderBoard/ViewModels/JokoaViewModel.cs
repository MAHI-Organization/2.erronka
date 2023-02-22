using MAHI_LeaderBoard.Models;

namespace MAHI_LeaderBoard.ViewModels
{
    public class JokoaViewModel
    {
        public string JokoaIzena;
        public float BatazBestekoBalorazioa { get; set; }
        public IList<Komentarioa> KomentarioaVMList { get; set; }
        public IList<Balorazioa> BalorazioakVMList { get; set; }
        public IList<Partida> PartidaVMList { get; set;}
    }
}
