using MAHI_LeaderBoard.Models;

namespace MAHI_LeaderBoard.Services
{
    public interface IPartidaService
    {
        public Task<List<Partida>> GetJokoarenPartidak(string uri);
    }
}
