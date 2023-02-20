using MAHI_LeaderBoard.Models;
using Newtonsoft.Json;

namespace MAHI_LeaderBoard.Services
{
    public class BalorazioaService : IBalorazioaService
    {
        private Uri rutaTodos = new Uri("http://localhost:8080/balorazioak/");

        public async Task<float> GetBatazBestekoBalorazioa(string jokoaIzena)
        {
            Uri rutaBalorazioak = new Uri(rutaTodos, "batazBestekoBalorazioa/?jokoarenIzena=" + jokoaIzena);
            float balorazioa = 0;
            using (var httpClient = new HttpClient())
            {
                using (var response = await httpClient.GetAsync(rutaBalorazioak))
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    balorazioa = JsonConvert.DeserializeObject<float>(apiResponse);
                }
            }
            return balorazioa;
        }

        public async Task<List<Balorazioa>> GetJokoarenBalorazioak(string jokoaIzena)
        {
            Uri rutaBalorazioak = new Uri(rutaTodos, "jokoarenBalorazioak/?jokoarenIzena=" + jokoaIzena);
            List<Balorazioa> balorazioak;
            using (var httpClient = new HttpClient())
            {
                using (var response = await httpClient.GetAsync(rutaBalorazioak))
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    balorazioak = JsonConvert.DeserializeObject<List<Balorazioa>>(apiResponse);
                }
            }
            return balorazioak;
        }
    }
}
