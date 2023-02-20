using MAHI_LeaderBoard.Models;
using Newtonsoft.Json;

namespace MAHI_LeaderBoard.Services
{
    public class KomentarioaService : IKomentarioaService
    {
        private Uri rutaTodos = new Uri("http://localhost:8080/komentarioak/");
        public async Task<List<Komentarioa>> GetKomentarioGuztiak()
        {
            List<Komentarioa> komentarioakList = new List<Komentarioa>();
            Uri rutaKomentarioak = new Uri(rutaTodos, "komentarioGuztiak");
            using (var httpClient = new HttpClient())
            {
                using (var response = await httpClient.GetAsync(rutaKomentarioak))
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    komentarioakList = JsonConvert.DeserializeObject<List<Komentarioa>>(apiResponse);
                }
            }
            return komentarioakList;
        }

        public async Task<List<Komentarioa>> GetJokoarenKomentarioak(string jokoarenIzena)
        {
            List<Komentarioa> komentarioakList = new List<Komentarioa>();
            Uri rutaKomentarioak = new Uri(rutaTodos, "jokoarenKomentarioak/?jokoa=" + jokoarenIzena);
            using (var httpClient = new HttpClient())
            {
                using (var response = await httpClient.GetAsync(rutaKomentarioak))
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    komentarioakList = JsonConvert.DeserializeObject<List<Komentarioa>>(apiResponse);
                }
            }
            return komentarioakList;
        }
    }
}
