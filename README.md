# CustomPhoneFormatter


Mask can be created as PhoneCountry object:

`val phoneCountry = PhoneCountry("GB", "44", 10, "NNNN NNNNNN")`


### To start 
* clone or download repository, copy classes PhoneFormatter and PhoneCountry to your project. 

* you need to provide PhoneFormatter with list of masks.

  `val phoneFormatter = PhoneFormatter.initialize(phoneCountries)`

* then call 

  `phoneFormatter.format(phoneString)`
