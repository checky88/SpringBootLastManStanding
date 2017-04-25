angular.module('app.controllers', [])
	.controller('FixtureListController', function($scope, $state, popupService, $window, Fixture) {
	$scope.fixtures = Fixture.query(); //fetch all fixtures. Issues a GET to /api/v1/fixtures
	//console.log(fixtures);
  
}).controller('FixtureViewController', function($scope, $stateParams, Fixture) {
	  $scope.fixture = Fixture.get({ id: $stateParams.id }); //Get a single fixture.Issues a GET to /api/v1/fixtures/:id
}).controller('CustomerListController', function($scope, $state, popupService, $window, Customer) {
	  $scope.customers = Customer.query(); //fetch all customers. Issues a GET to /api/v1/customers
}).controller('CustomerViewController', function($scope, $stateParams, Customer) {
	  $scope.customer = Customer.get({ id: $stateParams.id });
});