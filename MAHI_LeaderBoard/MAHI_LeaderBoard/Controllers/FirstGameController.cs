using MAHI_LeaderBoard.Models;
using Microsoft.AspNetCore.Mvc;
using MongoDB.Driver;
using System.Net.Http.Headers;

namespace MAHI_LeaderBoard.Controllers
{
    
    public class FirstGameController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }
        
        [Route("guardar_datos")]
        [HttpPost]

        public async Task<IActionResult> GuardarDatos(Inkesta inkestak)
        {
            // Verifica que los datos del cuestionario se hayan proporcionado correctamente
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            try
            {
                using (var client = new HttpClient())
                {
                    // Establece la URL de la API
                    client.BaseAddress = new Uri("http://localhost:8080/swagger-ui/index.html");

                    // Establece el tipo de contenido que se enviará en la petición
                    client.DefaultRequestHeaders.Accept.Clear();
                    client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));

                    // Envía los datos del cuestionario a la API
                    HttpResponseMessage response = await client.PostAsJsonAsync("api/guardar_datos", inkestak);

                    // Verifica si la petición se ha completado correctamente
                    if (response.IsSuccessStatusCode)
                    {
                        return Ok();
                    }
                    else
                    {
                        return StatusCode(500, response.ReasonPhrase);
                    }
                }
            }
            catch (Exception ex)
            {
                return StatusCode(500, ex.Message);
            }
        }
    }
}
       /* public IActionResult GuardarDatos(Inkesta inkestak)
        {
            // Verifica que los datos del cuestionario se hayan proporcionado correctamente
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            // Conéctate a MongoDB y guarda los datos del cuestionario
            try
            {
                // Crea una instancia de MongoClient para conectarte a la base de datos
                var client = new MongoClient("mongodb://localhost:27017");

                // Obtén una referencia a la base de datos
                var database = client.GetDatabase("erronka2");

                // Obtén una referencia a la colección de cuestionarios
                var cuestionariosCollection = database.GetCollection<Inkesta>("inkestak");

                // Inserta los datos del cuestionario en la colección de cuestionarios
                cuestionariosCollection.InsertOne(inkestak);

                // Cierra la conexión a MongoDB
                client = null;
            }
            catch (Exception ex)
            {
                return StatusCode(500, ex.Message);
            }

            return Ok();
        }  */
    


