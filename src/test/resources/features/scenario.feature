@wip
  Feature:Donation form
    Scenario:Donation form for betterplace.com
      Given the user is on the betterplace page
      When the user clicks login button
      And the login page shows as expected
      And the user logins with valid credentials
      Then the user sign in successfully "Erfolgreich eingeloggt!"