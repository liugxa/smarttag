var MINUTE = 60 * 1000;
var HOUR = 60 * MINUTE;
var DAY = 24 * HOUR;
var WEEK = 7 * DAY;

// This function gets called when the end-user clicks on some date.
function selected(cal, date) {
	// just update the date in the input field.
	cal.sel.value = date;
	cal.callCloseHandler();
}

// This function gets called when the end-user clicks on some date.
function selected(cal, date) {
  // update the date in the input field.
  cal.sel.value = date;
  if (cal.dateClicked)
    // if user clicked a date, then close the calendar.
    cal.callCloseHandler();
}

// And this gets called when the end-user clicks on the _selected_ date,
// or clicks on the "Close" button.  It just hides the calendar without
// destroying it.
function closeHandler(cal) {
	cal.hide();
	_dynarch_popupCalendar = null;
}

// This function shows the calendar under the element having the given id.
// It takes care of catching "mousedown" signals on document and hiding the
// calendar if the click was outside.
function showCalendar(id, format, showsTime, showsOtherMonths) {

	var targetDate = document.getElementById(id);
	
	if (_dynarch_popupCalendar != null) {
		// we already have some calendar created
		// so we hide it first.
		_dynarch_popupCalendar.hide();
	} else {
		// first-time call, create the calendar.
		var cal = new Calendar(0, null, selected, closeHandler);
		
		// hide the week numbers
		cal.weekNumbers = false;
		if (typeof showsTime == "string") {
			cal.showsTime = true;
			cal.time24 = (showsTime == "24");
		}
		if (showsOtherMonths) {
			cal.showsOtherMonths = true;
		}
		
		// remember it in the global var
		_dynarch_popupCalendar = cal;
		
		// min/max year allowed.
		cal.setRange(1900, 2070);
		cal.create();
	}
	
	// set the specified date format
	_dynarch_popupCalendar.setDateFormat(format);
	// try to parse the text in field
	_dynarch_popupCalendar.parseDate(targetDate.value);
	// inform it what input field we use
	_dynarch_popupCalendar.sel = targetDate;
	
	// the reference element that we pass to showAtElement is the button that
	// triggers the calendar.  In this example we align the calendar bottom-right
	// to the button.
	// show the calendar
	var showHere = document.getElementById(targetDate.id+"_i");
	_dynarch_popupCalendar.showAtElement(showHere, "Br");
	
	return false;
}

// If this handler returns true then the "date" given as
// parameter will be disabled.  In this example we enable
// only days within a range of 10 days from the current
// date.
// You can use the functions date.getFullYear() -- returns the year
// as 4 digit number, date.getMonth() -- returns the month as 0..11,
// and date.getDate() -- returns the date of the month as 1..31, to
// make heavy calculations here.  However, beware that this function
// should be very fast, as it is called for each day in a month when
// the calendar is (re)constructed.
function isDisabled(date) {
	var today = new Date();
	return (Math.abs(date.getTime() - today.getTime()) / DAY) > 10;
}


