var app = angular.module('produtoModule',[]);

app.controller('produtoControl',function($scope,$http){
	
	//$scope.pessoas = [{'codigo':'1','nome':'carlos'},
	//{'codigo':'2','nome':'marcos'}]

	var url = 'http://localhost:8080/Ecomerce/produto';
	var urlCategoria = 'http://localhost:8080/Ecomerce/categoria';
	
	$scope.pesquisar = function(){
		console.log('teste buscar');
		$http.get(url).success(function(produtosRetorno){
			$scope.produtos = produtosRetorno;
		}).error(function(mensagemErro){
			alert(mensagemErro)
		})
	}
	
	$scope.pesquisarCategoria = function(){
		$http.get(urlCategoria).success(function(categoriasRetorno){
			$scope.categorias = categoriasRetorno;
		}).error(function(mensagemErro){
			alert(mensagemErro)
		})
	}

	$scope.novo = function(){
		$scope.produto = {};
		$scope.produto.nome = [];
		$scope.produto.valor = [];
		$scope.produto.marca = [];
	}
	
	$scope.montaMensagemErro = function(listaErro) {
		$scope.mensagens = [];
		$scope.mensagens.push('Falha de validação retornada do servidor');
		angular.forEach(listaErro, function(value, key){
			 $scope.mensagens.push(value.message);
		});
	}

    $scope.salvar = function() {    	
		console.log('teste');
    	if($scope.produto.id == ''){
			console.log('teste1');
			$http.post(url,$scope.produto).success(function(produto){
				$scope.produtos.push($scope.produto);
				$scope.novo();
			}).error(function(erro){
				alert(erro);
			});
		}else {
			$http.put(url, $scope.produto).success(function(produto){
				$scope.pesquisar();
				$scope.novo();
			}).error(function(erro){
				alert(erro);
			});
		}
	}
	
	$scope.excluir = function() {
		if ($scope.produto.id == '') {
			alert('Selecione uma produto');
		} else {
			urlExcluir = url+'/'+$scope.produto.id;
			$http.delete(urlExcluir).success(function(){
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Produto excluído com sucesso');
			}).error(function(erro){
				alert(erro);
			});	
		}
	}
	
	$scope.seleciona = function(produtoTabela) {
		$scope.produto = produtoTabela;
	}
	
	$scope.pesquisar();
	$scope.pesquisarCategoria();
	$scope.novo();
});