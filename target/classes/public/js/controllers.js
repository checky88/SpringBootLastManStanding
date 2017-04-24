angular.module('app.controllers', []).controller('FixtureListController', function($scope, $state, popupService, $window, Fixture) {
  $scope.fixtures = Fixture.query(); //fetch all shipwrecks. Issues a GET to /api/vi/shipwrecks
  
}).controller('FixtureViewController', function($scope, $stateParams, Fixture) {
	  $scope.fixture = Fixture.get({ id: $stateParams.id }); //Get a single shipwreck.Issues a GET to /api/v1/shipwrecks/:id
});
