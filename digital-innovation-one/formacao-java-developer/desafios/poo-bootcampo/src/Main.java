import java.time.LocalDate;
import java.util.Set;

import dominio.Bootcamp;
import dominio.Curso;
import dominio.Dev;
import dominio.Mentoria;

public class Main {
    public static void main(String[] args) throws Exception {
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso Java");
        curso1.setDescricao("Curso de Java para iniciantes");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso Python");
        curso2.setDescricao("Curso de Python para iniciantes");
        curso2.setCargaHoraria(8);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria de Java");
        mentoria.setDescricao("Mentoria de Java para iniciantes");
        mentoria.setData(LocalDate.now());

        System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(mentoria);

        Bootcamp bootcamp = new Bootcamp("Bootcamp Java Developer", "Bootcamp de Java",
                Set.of(curso1, curso2, mentoria));

        System.out.println("============================================");

        Dev devCamila = new Dev("Camila");
        devCamila.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos inscritos pela Camila: " + devCamila.getConteudosInscritos());
        devCamila.progredir();
        System.out.println("EXP: " + devCamila.calcularTotalXp());
        System.out.println("============================================");
        System.out.println("Conteúdos inscritos pela Camila: " + devCamila.getConteudosInscritos());
        System.out.println("Conteúdos concluídos pela Camila: " + devCamila.getConteudosConcluidos());
        
        Dev devJoao = new Dev("João");
        System.out.println("Conteúdos inscritos pelo João: " + devJoao.getConteudosInscritos());
        devJoao.inscreverBootcamp(bootcamp);
        devJoao.progredir();
        System.out.println("EXP: " + devJoao.calcularTotalXp());
        System.out.println("============================================");
        System.out.println("Conteúdos concluídos pelo João: " + devJoao.getConteudosConcluidos());

    }
}
