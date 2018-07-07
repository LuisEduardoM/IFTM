var app = angular.module('itemPedidoModule',[]);

app.controller('itemPedidoControl',function($scope,$http){
	
	//$scope.pessoas = [{'codigo':'1','nome':'carlos'},
	//{'codigo':'2','nome':'marcos'}]

	var url = 'http://localhost:8080/Ecomerce/itemPedido';
	var urlPedido = 'http://localhost:8080/Ecomerce/pedido';
	var urlProduto = 'http://localhost:8080/Ecomerce/produto';

	$scope.pesquisar = function(){
		$http.get(url).success(function(itemPedidosRetorno){
			$scope.itemPedidos = itemPedidosRetorno;
		}).error(function(mensagemErro){
			alert(mensagemErro)
		})
	}

	$scope.pesquisarPedidos = function(){
		$http.get(urlPedido).success(function(pedidosRetorno){
			$scope.pedidos = pedidosRetorno;
		}).error(function(mensagemErro){
			alert(mensagemErro)
		})
	}

	$scope.pesquisarProdutos = function(){
		$http.get(urlProduto).success(function(produtosRetorno){
			$scope.produtos = produtosRetorno;
		}).error(function(mensagemErro){
			alert(mensagemErro)
		})
	}
	
	$scope.novo = function(){
		$scope.itemPedido = {};
	}
	
	$scope.montaMensagemErro = function(listaErro) {
		$scope.mensagens = [];
		$scope.mensagens.push('Falha de validação retornada do servidor');
		angular.forEach(listaErro, function(value, key){
			 $scope.mensagens.push(value.message);
		});
	}

    $scope.salvar = function() {    	
    	if($scope.itemPedido.id == ''){
			$http.post(url,$scope.itemPedido).success(function(itemPedido){
				$scope.itemPedidos.push($scope.itemPedido);
				$scope.novo();
			}).error(function(erro){
				alert(erro);
			});
		}else {
			$http.put(url, $scope.itemPedido).success(function(itemPedido){
				$scope.pesquisar();
				$scope.novo();
			}).error(function(erro){
				alert(erro);
			});
		}
	}
	
	$scope.excluir = function() {
		if ($scope.itemPedido.id == '') {
			alert('Selecione um Item do Pedido');
		} else {
			urlExcluir = url+'/'+$scope.itemPedido.id;
			$http.delete(urlExcluir).success(function(){
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Item do Pedido excluído com sucesso');
			}).error(function(erro){
				alert(erro);
			});	
		}
	}
	
	$scope.seleciona = function(itemPedidoTabela) {
		$scope.itemPedido = itemPedidoTabela;
	}
	
	$scope.pesquisar();
	$scope.pesquisarPedidos();
	$scope.pesquisarProdutos();
	$scope.novo();
});