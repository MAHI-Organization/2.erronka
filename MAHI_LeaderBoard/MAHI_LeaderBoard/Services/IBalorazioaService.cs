using MAHI_LeaderBoard.Models;

namespace MAHI_LeaderBoard.Services
{
    public interface IBalorazioaService
    {
        public Task<float> GetBatazBestekoBalorazioa(string jokoaIzena);

        public Task<List<Balorazioa>> GetJokoarenBalorazioak(string jokoaIzena);
    }
}
