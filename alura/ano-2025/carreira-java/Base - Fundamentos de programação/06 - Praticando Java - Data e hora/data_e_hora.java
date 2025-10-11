import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class data_e_hora {
    public static void main(String[] args) {
        System.out.println("=== Manipulando datas e horas ===\n");

        // Exemplo 1: Data atual com LocalDate
        System.out.println("Data atual (LocalDate): Apenas ano, mês e dia.");
        LocalDate dataAtual = LocalDate.now();
        System.out.println("Data atual: " + dataAtual); // Ex: 2025-10-10
        System.out.println();

        // Exemplo 2: Hora atual com LocalTime
        System.out.println("Hora atual (LocalTime): Apenas hora, minuto e segundo.");
        LocalTime horaAtual = LocalTime.now();
        System.out.println("Hora atual: " + horaAtual); // Ex: 19:00:25
        System.out.println();

        // Exemplo 3: Data e hora atual com LocalDateTime
        System.out.println("Data e hora atual (LocalDateTime): Ano, mês, dia, hora, minuto e segundo.");
        LocalDateTime dataHoraAtual = LocalDateTime.now();
        System.out.println("Data e hora atual: " + dataHoraAtual); // Ex: 2025-10-10T19:00:25
        System.out.println();

        // Exemplo 4: Criando datas e horas específicas
        System.out.println("Criando uma data específica (20/08/2026):");
        LocalDate dataEspecifica = LocalDate.of(2026, 8, 20);
        System.out.println("Data específica: " + dataEspecifica); // Ex: 2026-08-20

        System.out.println("Criando uma hora específica (14:30:00):");
        LocalTime horaEspecifica = LocalTime.of(14, 30, 0);
        System.out.println("Hora específica: " + horaEspecifica); // Ex: 14:30

        System.out.println("Criando data e hora específicas (20/08/2026 14:30:00):");
        LocalDateTime dataHoraEspecifica = LocalDateTime.of(dataEspecifica, horaEspecifica);
        System.out.println("Data e hora específicas: " + dataHoraEspecifica); // Ex: 2026-08-20T14:30:00
        System.out.println();

        // Exemplo 5: Adicionando ou subtraindo tempo
        System.out.println("Adicionando 5 dias à data atual:");
        LocalDate dataFutura = dataAtual.plusDays(5);
        System.out.println("Nova data: " + dataFutura);

        System.out.println("Subtraindo 2 horas da hora atual:");
        LocalTime horaPassada = horaAtual.minusHours(2);
        System.out.println("Hora anterior: " + horaPassada);
        System.out.println();

        // Exemplo 6: Formatando datas e horas
        System.out.println("Formatando data e hora:");
        DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatadorHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter formatadorDataHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        String dataFormatada = dataAtual.format(formatadorData);
        String horaFormatada = horaAtual.format(formatadorHora);
        String dataHoraFormatada = dataHoraAtual.format(formatadorDataHora);

        System.out.println("Data formatada: " + dataFormatada);           // Ex: 10/10/2025
        System.out.println("Hora formatada: " + horaFormatada);           // Ex: 19:00:25
        System.out.println("Data e hora formatadas: " + dataHoraFormatada); // Ex: 10/10/2025 19:00:25
        System.out.println();

        // Exemplo 7: Comparando datas
        System.out.println("Comparando datas:");
        if (dataAtual.isBefore(dataEspecifica)) {
            System.out.println("A data atual é antes de " + dataEspecifica);
        } else if (dataAtual.isAfter(dataEspecifica)) {
            System.out.println("A data atual é depois de " + dataEspecifica);
        } else {
            System.out.println("A data atual é igual a " + dataEspecifica);
        }
        System.out.println();

        // Exemplo 8: Convertendo String para data/hora
        System.out.println("Convertendo String para data/hora:");
        String textoData = "15/09/2024";
        String textoHora = "08:45:00";
        LocalDate dataConvertida = LocalDate.parse(textoData, formatadorData);
        LocalTime horaConvertida = LocalTime.parse(textoHora, formatadorHora);
        System.out.println("Data convertida: " + dataConvertida);
        System.out.println("Hora convertida: " + horaConvertida);

        System.out.println();
        System.out.println("=== Fim dos exemplos de manipulação de datas e horas ===\n");
    }
}
