using MAHI_LeaderBoard.Models;

namespace MAHI_LeaderBoard.Services
{
    public interface IKomentarioaService
    {
        Task<List<Komentarioa>> GetKomentarioGuztiak();
        Task<List<Komentarioa>> GetJokoarenKomentarioak(string izena);
    }
}
