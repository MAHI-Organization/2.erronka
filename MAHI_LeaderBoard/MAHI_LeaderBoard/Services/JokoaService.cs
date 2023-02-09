using MAHI_LeaderBoard.Models;
using Newtonsoft.Json;

namespace MAHI_LeaderBoard.Services
{
    public class JokoaService
    {
        private Uri rutaTodos = new Uri("https://localhost/api/Jokoa/");
        public async Task<IList<JokoaInkesta>> GetErabiltzailea(int id)
        {
            List<JokoaInkesta> jokoaInkestaList = new List<JokoaInkesta>();
            Uri rutaPartidak = new Uri(rutaTodos, "Erabiltzailea/" + id.ToString());
            using (var httpClient = new HttpClient())
            {
                using (var response = await httpClient.GetAsync(rutaPartidak)) 
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    jokoaInkestaList = JsonConvert.DeserializeObject<List<JokoaInkesta>>(apiResponse);
                }
            }
            return jokoaInkestaList;
        }
    }
}
