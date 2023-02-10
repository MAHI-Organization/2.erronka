namespace MAHI_LeaderBoard.Models
{
    public class Komentarioa
    {
        public int Id { get; set; }
        public string Erabiltzailea { get; set; }
        public Jokoa jokoa { get; set; }
        public string komentarioa { get; set; }
    }
}
