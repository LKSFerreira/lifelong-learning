using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http.Headers;
using System.Threading.Tasks;

namespace simulatec.Services;

public class HttpService
{
    public static HttpClient RequisicaoAPI(string endpoint)
    {
        HttpClient client = new()
        {
            BaseAddress = new Uri($"https://localhost:7198/api/{endpoint}")
        };

        client.DefaultRequestHeaders.Accept.Clear();
        client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", DashboardService.Token);
        client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
        
        return client;
    }
}
