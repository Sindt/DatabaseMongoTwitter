angular.module('Factory', []).factory('dataFactory', function($http) {

	var urlBase = '/resources/twitter';
	var dataFactory = {};

	dataFactory.getCountAllUsers = function() {
		return $http.get(urlBase + '/count');
	};
	dataFactory.getLinksUsers = function() {
		return $http.get(urlBase + '/links');
	};
	dataFactory.getActiveUsers = function() {
		return $http.get(urlBase + '/active');
	};
	dataFactory.getMentionedUsers = function() {
		return $http.get(urlBase + '/mentioned');
	};
	dataFactory.getNegativeUsers = function() {
		return $http.get(urlBase + '/negative');
	};
	dataFactory.getPositiveUsers = function() {
		return $http.get(urlBase + '/positive');
	};

	return dataFactory;
})

.config(function($locationProvider) {
	$locationProvider.html5Mode(true);
});