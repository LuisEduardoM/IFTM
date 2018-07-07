var app = angular.module('categoriaModule',[]);

app.controller('categoriaControl',function($scope,$http){
	
	//$scope.pessoas = [{'codigo':'1','nome':'carlos'},
	//{'codigo':'2','nome':'marcos'}]

	var url = 'http://localhost:8080/Ecomerce/categoria';
	
	$scope.pesquisar = function(){
		$http.get(url).success(function(categoriasRetorno){
			$scope.categorias = categoriasRetorno;
		}).error(function(mensagemErro){
			alert(mensagemErro)
		})
	}
	
	$scope.novo = function(){
		$scope.categoria = {};
		$scope.categoria.descricao = [];
	}
	
	$scope.montaMensagemErro = function(listaErro) {
		$scope.mensagens = [];
		$scope.mensagens.push('Falha de validação retornada do servidor');
		angular.forEach(listaErro, function(value, key){
			 $scope.mensagens.push(value.message);
		});
	}

    $scope.salvar = function() {    	
    	if($scope.categoria.id == ''){
			$http.post(url,$scope.categoria).success(function(categoria){
				$scope.categorias.push($scope.categoria);
				$scope.novo();
			}).error(function(erro){
				alert(erro);
			});
		}else {
			$http.put(url, $scope.categoria).success(function(categoria){
				$scope.pesquisar();
				$scope.novo();
			}).error(function(erro){
				alert(erro);
			});
		}
	}
	
	$scope.excluir = function() {
		if ($scope.categoria.id == '') {
			alert('Selecione uma categoria');
		} else {
			urlExcluir = url+'/'+$scope.categoria.id;
			$http.delete(urlExcluir).success(function(){
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Categoria excluída com sucesso');
			}).error(function(erro){
				alert(erro);
			});	
		}
	}
	
	$scope.seleciona = function(categoriaTabela) {
		$scope.categoria = categoriaTabela;
	}
	
	$scope.pesquisar();
	$scope.novo();
});