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
	  $scope.customers = Customer.query();//fetch all customers. Issues a GET to /api/v1/customers
	  console.log($scope.customers);
}).controller('CustomerViewController', function($scope, $stateParams, Customer) {
	  $scope.customer = Customer.get({ id: $stateParams.id });
}).controller('HeadToHeadViewController', function($scope, $stateParams, HeadToHead) {
	  $scope.fixture = HeadToHead.query({ id: $stateParams.id });
}).controller('CustomerEditController', function($scope, $state, $stateParams, Customer) {
	  $scope.updateCustomer = function() { //Update the edited customer. Issues a PUT to /api/v1/customer/:id
		    $scope.customer.$update(function() {
		      $state.go('customers'); // on success go back to the list i.e. shipwrecks state.
		    });
		  };

		  $scope.loadCustomer = function() { //Issues a GET request to /api/v1/shipwrecks/:id to get a shipwreck to update
		    $scope.customer = Customer.get({ id: $stateParams.id });
		  };

		  $scope.loadCustomer(); // Load a shipwreck which can be edited on UI
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

