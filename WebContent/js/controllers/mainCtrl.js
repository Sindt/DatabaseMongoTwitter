angular.module('MainCtrl', []).controller(
		'MainController',
		function(dataFactory) {

			var self = this;

			self.getCountAllUsers = function() {
				dataFactory.getTestBeskeder().then(function(response) {
					self.testBeskeder = response.data;
				}, function(error) {
					self.status = 'Kunne ikke finde users: ' + error.message;
				});
			};
			self.getLinksUsers = function(id) {
				dataFactory.getTestBeskedById(id).then(function(response) {
					self.testBesked = response.data;
				}, function(error) {
					self.status = 'Kunne ikke finde users: ' + error.message;
				});
			};
			self.getMentionedUsers = function() {
				dataFactory.createTestBesked(self.testBesked).then(
						function(response) {
							self.status = response.data;
						},
						function(error) {
							self.status = 'Kunne ikke finde users: '
									+ error.status + " - " + error.statusText;
						});
			};
			self.getActiveUsers = function() {
				dataFactory.addTestBesked(self.readOnlyBesked).then(
						function(response) {
							self.status = response.data;
						},
						function(error) {
							self.status = 'Kunne ikke finde users: '
									+ error.status + " - " + error.statusText;
						});
			}
			self.getNegativeUsers = function() {
				dataFactory.addTestBesked(self.readOnlyBesked).then(
						function(response) {
							self.status = response.data;
						},
						function(error) {
							self.status = 'Kunne ikke finde users: '
									+ error.status + " - " + error.statusText;
						});
			}
			self.getPositiveUsers = function() {
				dataFactory.addTestBesked(self.readOnlyBesked).then(
						function(response) {
							self.status = response.data;
						},
						function(error) {
							self.status = 'Kunne ikke finde users: '
									+ error.status + " - " + error.statusText;
						});
			}

		});
