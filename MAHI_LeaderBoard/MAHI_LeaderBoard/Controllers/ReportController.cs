using AspNetCore.Reporting;
using Microsoft.AspNetCore.Mvc;
using System.Text;

public class ReportController : Controller
{
    private readonly IWebHostEnvironment _webHostEnvironment;
    public ReportController(IWebHostEnvironment webHostEnvironment)
    {
        _webHostEnvironment = webHostEnvironment;
    }
    public IActionResult Inprimatu()
    {
        Encoding.RegisterProvider(CodePagesEncodingProvider.Instance);

        string mimtype = "";
        int extension = 1;
        var path = $"{_webHostEnvironment.WebRootPath}\\Reports\\Informe.rdlc";
        Dictionary<string, string> parameters = new Dictionary<string, string>();
        parameters.Add("rp1", "Partidak");
        LocalReport localReport = new LocalReport(path);
        var result = localReport.Execute(RenderType.Pdf, extension, parameters, mimtype);
        return File(result.MainStream, "application/pdf");

    }
}
