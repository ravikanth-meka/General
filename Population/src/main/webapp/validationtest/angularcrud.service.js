(function()
{
	
	var app = angular.module("populationEntryApp");

	app.service("populationEntryService", function($http)
	{
		var self = this;


		self.insertData = function(method, url, $scope){
		
			return $http({	method : method,
					url : url,
					data : angular.toJson($scope.countryForm),
					headers : {'Content-Type' : 'application/json'	}})
				.then (function(response){
					//return response;
					console.log("inserted");
				})
			}
	});
})();