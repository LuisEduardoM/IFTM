var app = angular.module('pedidoModule',[]);

app.controller('pedidoControl',function($scope,$http){
	
	//$scope.pessoas = [{'codigo':'1','nome':'carlos'},
	//{'codigo':'2','nome':'marcos'}]

	var url = 'http://localhost:8080/Ecomerce/pedido';
	var urlCliente = 'http://localhost:8080/Ecomerce/cliente';
	
	$scope.pesquisar = function(){
		$http.get(url).success(function(pedidosRetorno){
			$scope.pedidos = pedidosRetorno;
		}).error(function(mensagemErro){
			alert(mensagemErro)
		})
	}

	$scope.pesquisarCliente = function(){
		$http.get(urlCliente).success(function(clientesRetorno){
			$scope.clientes = clientesRetorno;
		}).error(function(mensagemErro){
			alert(mensagemErro)
		})
	}
	
	$scope.novo = function(){
		$scope.pedido = {};
		
	}
	
	$scope.montaMensagemErro = function(listaErro) {
		$scope.mensagens = [];
		$scope.mensagens.push('Falha de validação retornada do servidor');
		angular.forEach(listaErro, function(value, key){
			 $scope.mensagens.push(value.message);
		});
	}

    $scope.salvar = function() {  
		split = $scope.pedido.data.split("/");
		novadata = split[1] + "/" +split[0]+"/"+split[2];
		data_americana = new Date(novadata);
		console.log(data_americana);
		$scope.pedido.data = data_americana;
    	if($scope.pedido.id == ''){
			$http.post(url,$scope.pedido).success(function(pedido){
				$scope.pedidos.push($scope.pedido);
				$scope.novo();
			}).error(function(erro){
				alert(erro);
			});
		}else {
			$http.put(url, $scope.pedido).success(function(pedido){
				$scope.pesquisar();
				$scope.novo();
			}).error(function(erro){
				alert(erro);
			});
		}
	}
	
	$scope.excluir = function() {
		if ($scope.pedido.id == '') {
			alert('Selecione um pedido');
		} else {
			urlExcluir = url+'/'+$scope.pedido.id;
			$http.delete(urlExcluir).success(function(){
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Pedido excluído com sucesso');
			}).error(function(erro){
				alert(erro);
			});	
		}
	}
	
	$scope.seleciona = function(pedidoTabela) {
		$scope.pedido = pedidoTabela;
		if($scope.pedido.data != ''){
			split = $scope.pedido.data.split("-");
			novadata = split[2] + "/" +split[1]+"/"+split[0];
			$scope.pedido.data = novadata;
		}
	}
	
	$scope.pesquisar();
	$scope.pesquisarCliente();
	$scope.novo();
});