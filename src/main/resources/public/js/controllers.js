angular.module('app.controllers', [])
	.controller('FixtureListController', function($scope, $state, popupService, $window, Fixture) {
	$scope.fixtures = Fixture.query(); //fetch all fixtures. Issues a GET to /api/v1/fixtures
	//console.log(fixtures);
  
}).controller('FixtureViewController', function($scope, $stateParams, Fixture) {
	  $scope.fixture = Fixture.get({ id: $stateParams.id }); //Get a single fixture.Issues a GET to /api/v1/fixtures/:id
}).controller('GameWeekViewController',function($scope, $stateParams, GameWeek) {
	  $scope.gameweek = GameWeek.query({ id: $stateParams.id });
	  console.log($scope.gameweek);
}).controller('CustomerListController', function($scope, $state, popupService, $window, Customer) {
	  $scope.customers = Customer.query(); //fetch all customers. Issues a GET to /api/v1/customers
}).controller('CustomerViewController', function($scope, $stateParams, Customer) {
	  $scope.customer = Customer.get({ id: $stateParams.id });
}).controller('HeadToHeadViewController', function($scope, $stateParams, HeadToHead) {
	  $scope.fixture = HeadToHead.query({ id: $stateParams.id });
}).filter('unique', function () {

	  return function (items, filterOn) {

	    if (filterOn === false) {
	      return items;
	    }

	    if ((filterOn || angular.isUndefined(filterOn)) && angular.isArray(items)) {
	      var hashCheck = {}, newItems = [];

	      var extractValueToCompare = function (item) {
	        if (angular.isObject(item) && angular.isString(filterOn)) {
	          return item[filterOn];
	        } else {
	          return item;
	        }
	      };

	      angular.forEach(items, function (item) {
	        var valueToCheck, isDuplicate = false;

	        for (var i = 0; i < newItems.length; i++) {
	          if (angular.equals(extractValueToCompare(newItems[i]), extractValueToCompare(item))) {
	            isDuplicate = true;
	            break;
	          }
	        }
	        if (!isDuplicate) {
	          newItems.push(item);
	        }

	      });
	      items = newItems;
	    }
	    return items;
	  };
	});


