package com.bwssystems.hass.test;

import java.util.Map;
import java.util.Map.Entry;

import com.bwssystems.HABridge.plugins.hass.Field;
import com.bwssystems.HABridge.plugins.hass.FieldDeserializer;
import com.bwssystems.HABridge.plugins.hass.Service;
import com.bwssystems.HABridge.plugins.hass.ServiceDeserializer;
import com.bwssystems.HABridge.plugins.hass.ServiceElement;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

public class ServiceDataConstructor {
	public final static String TestData = "[{\"domain\": \"homeassistant\", \"services\": {\"reload_core_config\": {\"description\": \"\", \"fields\": {}}, \"restart\": {\"description\": \"\", \"fields\": {}}, \"stop\": {\"description\": \"\", \"fields\": {}}, \"toggle\": {\"description\": \"\", \"fields\": {}}, \"turn_off\": {\"description\": \"\", \"fields\": {}}, \"turn_on\": {\"description\": \"\", \"fields\": {}}}}, {\"domain\": \"lock\", \"services\": {\"lock\": {\"description\": \"Lock all or specified locks\", \"fields\": {\"code\": {\"description\": \"An optional code to lock the lock with\", \"example\": 1234}, \"entity_id\": {\"description\": \"Name of lock to lock\", \"example\": \"lock.front_door\"}}}, \"unlock\": {\"description\": \"Unlock all or specified locks\", \"fields\": {\"code\": {\"description\": \"An optional code to unlock the lock with\", \"example\": 1234}, \"entity_id\": {\"description\": \"Name of lock to unlock\", \"example\": \"lock.front_door\"}}}}}, {\"domain\": \"light\", \"services\": {\"toggle\": {\"description\": \"Toggles a light\", \"fields\": {\"entity_id\": {\"description\": \"Name(s) of entities to toggle\", \"example\": \"light.kitchen\"}, \"transition\": {\"description\": \"Duration in seconds it takes to get to next state\", \"example\": 60}}}, \"turn_off\": {\"description\": \"Turn a light off\", \"fields\": {\"entity_id\": {\"description\": \"Name(s) of entities to turn off\", \"example\": \"light.kitchen\"}, \"flash\": {\"description\": \"If the light should flash\", \"values\": [\"short\", \"long\"]}, \"transition\": {\"description\": \"Duration in seconds it takes to get to next state\", \"example\": 60}}}, \"turn_on\": {\"description\": \"Turn a light on\", \"fields\": {\"brightness\": {\"description\": \"Number between 0..255 indicating brightness\", \"example\": 120}, \"color_name\": {\"description\": \"A human readable color name\", \"example\": \"red\"}, \"color_temp\": {\"description\": \"Color temperature for the light in mireds (154-500)\", \"example\": \"250\"}, \"effect\": {\"description\": \"Light effect\", \"values\": [\"colorloop\", \"random\"]}, \"entity_id\": {\"description\": \"Name(s) of entities to turn on\", \"example\": \"light.kitchen\"}, \"flash\": {\"description\": \"If the light should flash\", \"values\": [\"short\", \"long\"]}, \"profile\": {\"description\": \"Name of a light profile to use\", \"example\": \"relax\"}, \"rgb_color\": {\"description\": \"Color for the light in RGB-format\", \"example\": \"[255, 100, 100]\"}, \"transition\": {\"description\": \"Duration in seconds it takes to get to next state\", \"example\": 60}, \"white_value\": {\"description\": \"Number between 0..255 indicating level of white\", \"example\": \"250\"}, \"xy_color\": {\"description\": \"Color for the light in XY-format\", \"example\": \"[0.52, 0.43]\"}}}}}, {\"domain\": \"switch\", \"services\": {\"toggle\": {\"description\": \"Toggles a switch state\", \"fields\": {\"entity_id\": {\"description\": \"Name(s) of entities to toggle\", \"example\": \"switch.living_room\"}}}, \"turn_off\": {\"description\": \"Turn a switch off\", \"fields\": {\"entity_id\": {\"description\": \"Name(s) of entities to turn off\", \"example\": \"switch.living_room\"}}}, \"turn_on\": {\"description\": \"Turn a switch on\", \"fields\": {\"entity_id\": {\"description\": \"Name(s) of entities to turn on\", \"example\": \"switch.living_room\"}}}}}, {\"domain\": \"conversation\", \"services\": {\"process\": {\"description\": \"\", \"fields\": {}}}}, {\"domain\": \"climate\", \"services\": {\"set_aux_heat\": {\"description\": \"Turn auxillary heater on/off for climate device\", \"fields\": {\"aux_heat\": {\"description\": \"New value of axillary heater\", \"example\": true}, \"entity_id\": {\"description\": \"Name(s) of entities to change\", \"example\": \"climate.kitchen\"}}}, \"set_away_mode\": {\"description\": \"Turn away mode on/off for climate device\", \"fields\": {\"away_mode\": {\"description\": \"New value of away mode\", \"example\": true}, \"entity_id\": {\"description\": \"Name(s) of entities to change\", \"example\": \"climate.kitchen\"}}}, \"set_fan_mode\": {\"description\": \"Set fan operation for climate device\", \"fields\": {\"entity_id\": {\"description\": \"Name(s) of entities to change\", \"example\": \"climate.nest\"}, \"fan\": {\"description\": \"New value of fan mode\", \"example\": \"On Low\"}}}, \"set_humidity\": {\"description\": \"Set target humidity of climate device\", \"fields\": {\"entity_id\": {\"description\": \"Name(s) of entities to change\", \"example\": \"climate.kitchen\"}, \"humidity\": {\"description\": \"New target humidity for climate device\", \"example\": 60}}}, \"set_operation_mode\": {\"description\": \"Set operation mode for climate device\", \"fields\": {\"entity_id\": {\"description\": \"Name(s) of entities to change\", \"example\": \"climet.nest\"}, \"operation_mode\": {\"description\": \"New value of operation mode\", \"example\": \"Heat\"}}}, \"set_swing_mode\": {\"description\": \"Set swing operation for climate device\", \"fields\": {\"description\": \"New value of swing mode\", \"entity_id\": {\"description\": \"Name(s) of entities to change\", \"example\": \".nest\"}, \"example\": 1, \"swing_mode\": null}}, \"set_temperature\": {\"description\": \"Set target temperature of climate device\", \"fields\": {\"entity_id\": {\"description\": \"Name(s) of entities to change\", \"example\": \"climate.kitchen\"}, \"operation_mode\": {\"description\": \"Operation mode to set temperature to. This defaults to current_operation mode if not set, or set incorrectly.\", \"example\": \"Heat\"}, \"target_temp_high\": {\"description\": \"New target high tempereature for hvac\", \"example\": 26}, \"target_temp_low\": {\"description\": \"New target low temperature for hvac\", \"example\": 20}, \"temperature\": {\"description\": \"New target temperature for hvac\", \"example\": 25}}}}}, {\"domain\": \"cover\", \"services\": {\"close_cover\": {\"description\": \"Close all or specified cover\", \"fields\": {\"entity_id\": {\"description\": \"Name(s) of cover(s) to close\", \"example\": \"cover.living_room\"}}}, \"close_cover_tilt\": {\"description\": \"Close all or specified cover tilt\", \"fields\": {\"entity_id\": {\"description\": \"Name(s) of cover(s) to close tilt\", \"example\": \"cover.living_room\"}}}, \"open_cover\": {\"description\": \"Open all or specified cover\", \"fields\": {\"entity_id\": {\"description\": \"Name(s) of cover(s) to open\", \"example\": \"cover.living_room\"}}}, \"open_cover_tilt\": {\"description\": \"Open all or specified cover tilt\", \"fields\": {\"entity_id\": {\"description\": \"Name(s) of cover(s) tilt to open\", \"example\": \"cover.living_room\"}}}, \"set_cover_position\": {\"description\": \"Move to specific position all or specified cover\", \"fields\": {\"entity_id\": {\"description\": \"Name(s) of cover(s) to set cover position\", \"example\": \"cover.living_room\"}, \"position\": {\"description\": \"Position of the cover (0 to 100)\", \"example\": 30}}}, \"set_cover_tilt_position\": {\"description\": \"Move to specific position all or specified cover tilt\", \"fields\": {\"entity_id\": {\"description\": \"Name(s) of cover(s) to set cover tilt position\", \"example\": \"cover.living_room\"}, \"position\": {\"description\": \"Position of the cover (0 to 100)\", \"example\": 30}}}, \"stop_cover\": {\"description\": \"Stop all or specified cover\", \"fields\": {\"entity_id\": {\"description\": \"Name(s) of cover(s) to stop\", \"example\": \"cover.living_room\"}}}, \"stop_cover_tilt\": {\"description\": \"Stop all or specified cover\", \"fields\": {\"entity_id\": {\"description\": \"Name(s) of cover(s) to stop\", \"example\": \"cover.living_room\"}}}}}, {\"domain\": \"persistent_notification\", \"services\": {\"create\": {\"description\": \"Show a notification in the frontend\", \"fields\": {\"message\": {\"description\": \"Message body of the notification. [Templates accepted]\", \"example\": \"Please check your configuration.yaml.\"}, \"notification_id\": {\"description\": \"Target ID of the notification, will replace a notification with the same Id. [Optional]\", \"example\": 1234}, \"title\": {\"description\": \"Optional title for your notification. [Optional, Templates accepted]\", \"example\": \"Test notification\"}}}}}, {\"domain\": \"logbook\", \"services\": {\"log\": {\"description\": \"\", \"fields\": {}}}}]";
	public static void main(String[] args){
		ServiceDataConstructor aTestService = new ServiceDataConstructor();
		if(aTestService.validateStructure())
			System.out.println("Test Successful");
	}

	public Boolean validateStructure() {
		Gson aGson;
		try {
			aGson = new GsonBuilder()
	                .registerTypeAdapter(Service.class, new ServiceDeserializer())
	                .registerTypeHierarchyAdapter(Field.class, new FieldDeserializer())
	                .create();
			
			Service[] aService = aGson.fromJson(TestData, Service[].class);
			for(int i = 0; i < aService.length; i++) {
				System.out.println(aService[i].getDomain());
				Map<String, ServiceElement> services = aService[i].getServices();
				for(Entry<String, ServiceElement> theServiceEntry:services.entrySet()) {
					System.out.println("    " + theServiceEntry.getKey());
					Field theField = theServiceEntry.getValue().getFields();
					for(Entry<String, JsonElement> theFieldEntry:theField.getFields().entrySet())
						System.out.println("        " + theFieldEntry.getKey());
				}
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
