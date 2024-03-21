package br.com.lksferreira.todolist.utils;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class Utils {

    // Método que copia as propriedades não nulas de um objeto para outro
    public static void copyNonNullProperties(Object source, Object target) {

        // BeanUtils é uma classe do Spring que possui o método copyProperties()
        // copyProperties() copia as propriedades de um objeto para outro
        // copyProperties() recebe como parâmetro o objeto de origem(source) e o objeto de destino(target)
        // copyProperties() copia todas as propriedades, inclusive as nulas

        BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
    }

    // Método do que retorna um array de String com os nomes das propriedades nulas
    public static String[] getNullPropertyNames(Object source) {
        // Cria um BeanWrapper com o objeto recebido, para que possamos acessar as
        // propriedades
        // BeanWrapper é a classe, e o BeanWrapperImpl é a implementação
        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);

        // Cria um array de PropertyDescriptor(Propriedade com o valores nulos)
        PropertyDescriptor[] propertyDescriptors = wrappedSource.getPropertyDescriptors();

        // Cria um Set de String para armazenar os nomes das propriedades nulas
        // Set é uma coleção que não aceita valores duplicados
        Set<String> emptyNames = new HashSet<String>();

        for (PropertyDescriptor property : propertyDescriptors) {
            // Cria um objeto com o valor da propriedade que está sendo iterada
            Object propertyValue = wrappedSource.getPropertyValue(property.getName());

            // Se for nula, adiciona o nome da propriedade no Set
            if (propertyValue == null) {
                // Adiciona o nome da propriedade nula a coleção Set
                emptyNames.add(property.getName());
            }
        }

        // Cria um array de String com o tamanho do Set
        String[] result = new String[emptyNames.size()];

        // Retorna o array de String com os nomes das propriedades nulas
        // Neste ponto o Set já está preenchido com os nomes das propriedades nulas
        // toArray() converte o Set(emptyNames) para um array de String(result)
        // toArray() recebe como parâmetro o array de String(result) que será preenchido
        // E retorna o array de String(result) preenchido
        return emptyNames.toArray(result);
    }
}
