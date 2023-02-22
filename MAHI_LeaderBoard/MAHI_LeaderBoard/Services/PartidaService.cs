using MAHI_LeaderBoard.Models;
using Newtonsoft.Json;

namespace MAHI_LeaderBoard.Services
{
    public class PartidaService : IPartidaService
    {
        //private Uri rutaTodos = new Uri("http://localhost:8080/partidak/");
        public async Task<List<Partida>> GetJokoarenPartidak(string ruta)
        {
            Uri rutaBalorazioak = new Uri(ruta);
            List<Partida> partidak;
            using (var httpClient = new HttpClient())
            {
                using (var response = await httpClient.GetAsync(rutaBalorazioak))
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    partidak = JsonConvert.DeserializeObject<List<Partida>>(apiResponse).OrderByDescending(x => x.puntuazioa).ToList();
                }
            }
            return partidak;
        }
    }
}
