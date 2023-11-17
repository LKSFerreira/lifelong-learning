using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using FerreiraPizzas.Models;
namespace FerreiraPizzas.Services
{
    public class PizzaService
    {
        static List<Pizza> Pizzas { get; set; }
        static int nextId = 3;

        static PizzaService()
        {
            Pizzas = new List<Pizza>
            {
                new Pizza {Id = 1, Name = "Class Italian", IsGlutenFree = false},
                new Pizza {Id = 2, Name = "Vaggie", IsGlutenFree = true},
                new Pizza {Id = 8, Name = "Portugesa", IsGlutenFree = false},
                new Pizza {Id = 9, Name = "A Moda da Casa", IsGlutenFree = true}
            };
        }

        public static List<Pizza> GetAll() => Pizzas;

        public static Pizza? Get(int id) => Pizzas.FirstOrDefault(pizza => pizza.Id == id);

        public static void Add(Pizza pizza)
        {
            pizza.Id = nextId++;
            Pizzas.Add(pizza);
        }

        public static void Delete(int id)
        {
            var pizza = Get(id);

            if (pizza is null)
            {
                return;
            }

            Pizzas.Remove(pizza);
        }

        public static void Update(Pizza pizza)
        {
            var index = Pizzas.FindIndex(pizza => pizza.Id == pizza.Id);

            if (index == -1)
            {
                return;
            }

            Pizzas[index] = pizza;
        }
    }
}