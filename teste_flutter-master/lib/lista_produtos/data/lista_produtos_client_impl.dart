import 'dart:convert';
import 'dart:io';

import 'package:teste_salcisne/lista_produtos/domain/entity/produto_entity.dart';
import 'package:http/http.dart' as http;

import '../domain/client/lista_produtos_client.dart';

class ProdutosClientImpl implements ProdutosClient {
  final String url = 'http://10.0.2.2:8080/estoque/find-all';
  var client = http.Client();

  @override
  Future<List<Produto>> getListaProdutos() async {
    try {
      var response = await http.get(url );


      if (response.statusCode == HttpStatus.ok) {
        final _json = json.decode(response.body);
        return _json
            .map<Produto>((_produtoJson) => Produto.fromJson(_produtoJson))
            .toList(growable: true);
      } else {
        throw http.ClientException("Houve um erro na requisição");
      }
    } catch (e) {
      throw http.ClientException("Erro inesperado");
    }
  }
}
