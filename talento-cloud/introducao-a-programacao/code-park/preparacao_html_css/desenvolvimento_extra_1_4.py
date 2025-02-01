lista_produtos = ['máscaras faciais', 'batons', 'esmaltes', 'perfumes', 'loções', 'xampus', 'sabonetes', 'delineadores']

# Substituir 'batons' por 'rímel'
indice_batons = lista_produtos.index('batons')
lista_produtos[indice_batons] = 'rímel'

# Substituir 'loções' por 'cremes hidratantes'
indice_loções = lista_produtos.index('loções')
lista_produtos[indice_loções] = 'cremes hidratantes'

# Remover 'delineadores' da lista
lista_produtos.remove('delineadores')

# Adicionar dois novos produtos à lista
lista_produtos.append('condicionadores')
lista_produtos.append('protetores solares')

# Imprimir a nova lista de produtos
for produto in lista_produtos:
    print(produto)
