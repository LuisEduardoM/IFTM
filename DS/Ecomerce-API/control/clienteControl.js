var app = angular.module('clienteModule',[]);

app.controller('clienteControl',function($scope,$http){
	
	//$scope.pessoas = [{'codigo':'1','nome':'carlos'},
	//{'codigo':'2','nome':'marcos'}]

	var url = 'http://localhost:8080/Ecomerce/cliente';
	
	$scope.pesquisar = function(){
		$http.get(url).success(function(clientesRetorno){
			$scope.clientes = clientesRetorno;
		}).error(function(mensagemErro){
			alert(mensagemErro)
		})
	}
	
	$scope.novo = function(){
		$scope.cliente = {};
		$scope.cliente.nome = [];
		$scope.cliente.telefone = [];
		$scope.cliente.email = [];
		$scope.cliente.senha = [];
	}
	
	$scope.montaMensagemErro = function(listaErro) {
		$scope.mensagens = [];
		$scope.mensagens.push('Falha de validação retornada do servidor');
		angular.forEach(listaErro, function(value, key){
			 $scope.mensagens.push(value.message);
		});
	}

    $scope.salvar = function() {    	
    	if($scope.cliente.id == ''){
			$http.post(url,$scope.cliente).success(function(cliente){
				$scope.clientes.push($scope.cliente);
				$scope.novo();
			}).error(function(erro){
				alert(erro);
			});
		}else {
			$http.put(url, $scope.cliente).success(function(cliente){
				$scope.pesquisar();
				$scope.novo();
			}).error(function(erro){
				alert(erro);
			});
		}
	}
	
	$scope.excluir = function() {
		if ($scope.cliente.id == '') {
			alert('Selecione um cliente');
		} else {
			urlExcluir = url+'/'+$scope.cliente.id;
			$http.delete(urlExcluir).success(function(){
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Cliente excluído com sucesso');
			}).error(function(erro){
				alert(erro);
			});	
		}
	}
	
	$scope.seleciona = function(clienteTabela) {
		$scope.cliente = clienteTabela;
	}
	
	$scope.pesquisar();
	$scope.novo();
});