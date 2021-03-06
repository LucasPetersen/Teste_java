import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:teste_salcisne/lista_produtos/domain/entity/produto_entity.dart';
import 'dart:developer' as developer;

import '../bloc/lista_produtos_bloc.dart';

class ListaProdutosWidget extends StatefulWidget {
  const ListaProdutosWidget({Key key}) : super(key: key);

  @override
  _ListaProdutosWidgetState createState() => _ListaProdutosWidgetState();
}

class _ListaProdutosWidgetState extends State<ListaProdutosWidget> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Lista de produtos'), 
						 actions: [ IconButton(onPressed: () {
							 BlocProvider.of<ListaProdutosBloc>(context).add(GetListaProdutos());
						 }, icon: Icon( Icons.cloud_download ), )],
					 ),
      body: BlocBuilder<ListaProdutosBloc,ListaProdutosState>(
        builder: (context, state) {
          developer.log(state.toString(), name: 'my.app.produtos');

          if (state is ListaProdutosInitial) {
            List<Produto> produtos = [
              Produto(nome: "Produto 1", local: "Local A", quantidade: 20),
              Produto(nome: "Produto 2", local: "Local B", quantidade: 18),
              Produto(nome: "Produto 3", local: "Local C", quantidade: 16),
            ];
            return buildProdutosList(produtos);
          } else if (state is Error) {
			  final errorState = state as Error;
			  final String erro = errorState.message;
            return Center(child: Text(erro));
          } else if (state is Loading) {
            return Center(child: CircularProgressIndicator());
          } else if (state is ListaCarregada) {
            final listaDeProdutosState = state as ListaCarregada;
            final List<Produto> listaDeProdutos = listaDeProdutosState.produtos;
            return buildProdutosList(listaDeProdutos);
          } else {
            return  Center(child: Text('State:$state'));
          }
        },
      ),
    );
  }

  Widget buildProdutosList(List<Produto> listaDeProdutos) {
    return Container(
        height: 800,
        child: ListView.builder(
          itemBuilder: (ctx, index) {
            return Card(
              child: Row(children: [
                Container(
                  width: 250,
                  margin: EdgeInsets.all(10),
                  alignment: Alignment.center,
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    mainAxisAlignment: MainAxisAlignment.spaceAround,
                    children: [
                      Text(listaDeProdutos[index].nome, style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold)),
                      Text(
                        listaDeProdutos[index].local,
                        softWrap: true,
                        textWidthBasis: TextWidthBasis.parent,
                        style: TextStyle(fontSize: 16, color: Colors.grey),
                      ),
                    ],
                  ),
                ),
                Container(
                    margin: EdgeInsets.symmetric(vertical: 10, horizontal: 15),
                    decoration: BoxDecoration(border: Border.all(width: 2)),
                    padding: EdgeInsets.all(10),
                    child: Text(
                      'Qtd:${listaDeProdutos[index].quantidade}',
                      style: TextStyle(fontWeight: FontWeight.bold, fontSize: 20),
                    )),
              ], mainAxisAlignment: MainAxisAlignment.spaceBetween,),
            );
          },
          itemCount: listaDeProdutos.length,
        ));
  }
}
