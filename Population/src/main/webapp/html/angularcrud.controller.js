(function()
{
	
	var app = angular.module("CountryManagementApp");

	//Controller Part  
	app.controller("CountryController", CountryController);
	
	
// function CountryController($scope, $http){
	function CountryController(CountryService, $scope, $http){
		
		$scope.countries = [];
		$scope.countryForm = {
			id : -1,
			countryName : "",
			population : ""
		};

		//Now load the data from server  
		_refreshCountryData();

		//HTTP POST/PUT methods for add/edit country   
		// with the help of id, we are going to find out whether it is put or post operation  

		$scope.submitCountry = function() {
			console.log("submitCountry...");
			var method = "";
			var url = "";
			if ($scope.countryForm.id == -1) {
				//Id is absent in form data, it is create new country operation  
				method = "POST";
				url = '/countries';
			} else {
				//Id is present in form data, it is edit country operation  
				method = "PUT";
				url = '/countries';
			}

			/*$http({
				method : method,
				url : url,
				data : angular.toJson($scope.countryForm),
				headers : {
					'Content-Type' : 'application/json'
				}
			}).then(_success, _error);
			*/
			CountryService.insertData(method, url,$scope)
			.then(_success, _error);
			console.log("insertData..");
			
		};

		//HTTP DELETE- delete country by Id  
		$scope.deleteCountry = function(country) {
			console.log("deleteCountry..");
			$http(
					{
						method : 'DELETE',
						url : '/country/'
								+ country.id
					}).then(_success, _error);
		};

		// In case of edit, populate form fields and assign form.id with country id  
		$scope.editCountry = function(country) {
			console.log("editCountry..");

			$scope.countryForm.countryName = country.countryName;
			$scope.countryForm.population = country.population;
			$scope.countryForm.id = country.id;
		};

		/* Private Methods */
		//HTTP GET- get all countries collection
		//url : 'http://localhost:8080/AngularjsSpringRestExample/countries'
		function _refreshCountryData() {
			console.log("refreshed data");
			$http(
					{
						method : 'GET',
						url : '/countries'
					}).then(function successCallback(response) {
				$scope.countries = response.data;
			}, function errorCallback(response) {
				console.log(response.statusText);
			});
		}

		function _success(response) {
			console.log("_success");
			_refreshCountryData();
			_clearFormData()
		}

		function _error(response) {
			console.log("error...");
			console.log(response.statusText);
		}

		//Clear the form  
		function _clearFormData() {
			$scope.countryForm.id = -1;
			$scope.countryForm.countryName = "";
			$scope.countryForm.population = "";

		};
	}
	
})();
