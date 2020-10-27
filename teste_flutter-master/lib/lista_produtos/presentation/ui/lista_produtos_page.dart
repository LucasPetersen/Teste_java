import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';

import '../bloc/lista_produtos_bloc.dart';
import 'lista_produtos_widget.dart';

class ListaProdutosPage extends StatefulWidget {
  const ListaProdutosPage({Key key}) : super(key: key);

  @override
  _ListaProdutosPageState createState() => _ListaProdutosPageState();
}

class _ListaProdutosPageState extends State<ListaProdutosPage> {
	ListaProdutosBloc _listaProdutosBloc;

	@override
	void initState() {
		super.initState();
		_listaProdutosBloc = ListaProdutosBloc();
	}

	@override
	void dispose( ) {
		super.dispose();
	}

	@override
  Widget build(BuildContext context) {
    return BlocProvider(
      create: (BuildContext context) => _listaProdutosBloc,
      child: ListaProdutosWidget(),
    );
  }


}
