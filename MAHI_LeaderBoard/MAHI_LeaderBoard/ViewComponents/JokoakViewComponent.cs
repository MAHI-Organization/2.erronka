using MAHI_LeaderBoard.Services;
using Microsoft.AspNetCore.Mvc;

public class JokoakViewComponent : ViewComponent
{
    private readonly IJokoaService _jokoaService;
    public JokoakViewComponent(IJokoaService jokoaService)
    {
        _jokoaService = jokoaService;
    }
    public async Task<IViewComponentResult> InvokeAsync(int id)
    {
        return View(await _jokoaService.GetErabiltzailea(id));
    }
}

