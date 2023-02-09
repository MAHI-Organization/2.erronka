using MAHI_LeaderBoard.Models;

namespace MAHI_LeaderBoard.Services
{
    public interface IJokoaService
    {
        Task<IList<JokoaInkesta>> GetErabiltzailea(int id);
    }
}
