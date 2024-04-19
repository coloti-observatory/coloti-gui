
package coloti.telescope;

import coloti.opcua.OpcUaConnector;

public class McsGetters{
private OpcUaConnector mc;
public McsGetters(OpcUaConnector mc) {
	this.mc=mc;
	}
public synchronized double getElSkyPos(){
return mc.getDoubleValue(EMcsVariables.EL_SKY_POS);
}
public synchronized double getElMotorCurrentLimit(){
return mc.getDoubleValue(EMcsVariables.EL_MOTOR_CURRENT_LIMIT);
}
public synchronized String getLogMessage(){
return mc.getStringValue(EMcsVariables.LOG_MESSAGE);
}
public synchronized double getElTelPos(){
return mc.getDoubleValue(EMcsVariables.EL_TEL_POS);
}
public synchronized boolean getSimulationActive(){
return mc.getBooleanValue(EMcsVariables.SIMULATION_ACTIVE);
}
public synchronized int getAzMotorsStatus(){
return mc.getIntValue(EMcsVariables.AZ_MOTORS_STATUS);
}
public synchronized double getTimeToTarget(){
return mc.getDoubleValue(EMcsVariables.TIME_TO_TARGET);
}
public synchronized boolean getPointingModelStatus(){
return mc.getBooleanValue(EMcsVariables.POINTING_MODEL_STATUS);
}
public synchronized String getStopAzParkingInfo(){
return mc.getStringValue(EMcsVariables.STOP_AZ_PARKING_INFO);
}
public synchronized long getSysTime(){
return mc.getLongValue(EMcsVariables.SYS_TIME);
}
public synchronized String getAzStowInInfo(){
return mc.getStringValue(EMcsVariables.AZ_STOW_IN_INFO);
}
public synchronized long getNtpLastUpdated(){
return mc.getLongValue(EMcsVariables.NTP_LAST_UPDATED);
}
public synchronized double getAc400vTotalActiveEnergy(){
return mc.getDoubleValue(EMcsVariables.AC400V_TOTAL_ACTIVE_ENERGY);
}
public synchronized String getDisableAzMotorsInfo(){
return mc.getStringValue(EMcsVariables.DISABLE_AZ_MOTORS_INFO);
}
public synchronized String getStopElMotionInfo(){
return mc.getStringValue(EMcsVariables.STOP_EL_MOTION_INFO);
}
public synchronized String getStartParkingInfo(){
return mc.getStringValue(EMcsVariables.START_PARKING_INFO);
}
public synchronized double getAzEncOffset(){
return mc.getDoubleValue(EMcsVariables.AZ_ENC_OFFSET);
}
public synchronized double getAzTpointCorrection(){
return mc.getDoubleValue(EMcsVariables.AZ_TPOINT_CORRECTION);
}
public synchronized double getRefractionCorrection(){
return mc.getDoubleValue(EMcsVariables.REFRACTION_CORRECTION);
}
public synchronized boolean getCircuitBreaker24vdcLockingPins(){
return mc.getBooleanValue(EMcsVariables.CIRCUIT_BREAKER_24VDC_LOCKING_PINS);
}
public synchronized double getSunPosAzimuth(){
return mc.getDoubleValue(EMcsVariables.SUN_POS_AZIMUTH);
}
public synchronized double getPh3Current(){
return mc.getDoubleValue(EMcsVariables.PH3_CURRENT);
}
public synchronized double getUtcJd(){
return mc.getDoubleValue(EMcsVariables.UTC_JD);
}
public synchronized boolean getPowerSupplyFault24vdcDrives(){
return mc.getBooleanValue(EMcsVariables.POWER_SUPPLY_FAULT_24VDC_DRIVES);
}
public synchronized String getStartAzMotionInfo(){
return mc.getStringValue(EMcsVariables.START_AZ_MOTION_INFO);
}
public synchronized double getH1LatchValue(){
return mc.getDoubleValue(EMcsVariables.H1_LATCH_VALUE);
}
public synchronized String getStartMotionInfo(){
return mc.getStringValue(EMcsVariables.START_MOTION_INFO);
}
public synchronized double getH2LatchValue(){
return mc.getDoubleValue(EMcsVariables.H2_LATCH_VALUE);
}
public synchronized double getElMotorCurrentNominal(){
return mc.getDoubleValue(EMcsVariables.EL_MOTOR_CURRENT_NOMINAL);
}
public synchronized String getStopAzEncInitInfo(){
return mc.getStringValue(EMcsVariables.STOP_AZ_ENC_INIT_INFO);
}
public synchronized double getH3LatchValue(){
return mc.getDoubleValue(EMcsVariables.H3_LATCH_VALUE);
}
public synchronized boolean getRefractionStatus(){
return mc.getBooleanValue(EMcsVariables.REFRACTION_STATUS);
}
public synchronized double getH4LatchValue(){
return mc.getDoubleValue(EMcsVariables.H4_LATCH_VALUE);
}
public synchronized double getElTpointCorrection(){
return mc.getDoubleValue(EMcsVariables.EL_TPOINT_CORRECTION);
}
public synchronized String getDrive400vacOffInfo(){
return mc.getStringValue(EMcsVariables.DRIVE_400VAC_OFF_INFO);
}
public synchronized double getAzMotorResolverCommandedCurrent(){
return mc.getDoubleValue(EMcsVariables.AZ_MOTOR_RESOLVER_COMMANDED_CURRENT);
}
public synchronized boolean getPowerSupplyFault24vdcNodeA210A218(){
return mc.getBooleanValue(EMcsVariables.POWER_SUPPLY_FAULT_24VDC_NODE_A210);
}
public synchronized double getPh3ApparentPower(){
return mc.getDoubleValue(EMcsVariables.PH3_APPARENT_POWER);
}
public synchronized double getAzMotorEncoderTemperature(){
return mc.getDoubleValue(EMcsVariables.AZ_MOTOR_ENCODER_TEMPERATURE);
}
public synchronized boolean getDoorBase(){
return mc.getBooleanValue(EMcsVariables.DOOR_BASE);
}
public synchronized String getPmcOnInfo(){
return mc.getStringValue(EMcsVariables.PMC_ON_INFO);
}
public synchronized String getAzResolverMotorType(){
return mc.getStringValue(EMcsVariables.AZ_RESOLVER_MOTOR_TYPE);
}
public synchronized double getCabTempHpc(){
return mc.getDoubleValue(EMcsVariables.CAB_TEMP_HPC);
}
public synchronized boolean getElLsOHigh(){
return mc.getBooleanValue(EMcsVariables.EL_LS_O_HIGH);
}
public synchronized boolean getLyreStatus(){
return mc.getBooleanValue(EMcsVariables.LYRE_STATUS);
}
public synchronized String getDisableElMotorInfo(){
return mc.getStringValue(EMcsVariables.DISABLE_EL_MOTOR_INFO);
}
public synchronized int getMotionStateElevation(){
return mc.getIntValue(EMcsVariables.MOTION_STATE_ELEVATION);
}
public synchronized String getResetAlarmsInfo(){
return mc.getStringValue(EMcsVariables.RESET_ALARMS_INFO);
}
public synchronized boolean getPowerSupplyFault24vdcNodeA101(){
return mc.getBooleanValue(EMcsVariables.POWER_SUPPLY_FAULT_24VDC_NODE_A101);
}
public synchronized String getUpdateTrajectoryInfo(){
return mc.getStringValue(EMcsVariables.UPDATE_TRAJECTORY_INFO);
}
public synchronized double getPh3Cosphi(){
return mc.getDoubleValue(EMcsVariables.PH3_COSPHI);
}
public synchronized String getPcRestartInfo(){
return mc.getStringValue(EMcsVariables.PC_RESTART_INFO);
}
public synchronized int getInitResult(){
return mc.getIntValue(EMcsVariables.INIT_RESULT);
}
public synchronized double getAzCommandedAcc(){
return mc.getDoubleValue(EMcsVariables.AZ_COMMANDED_ACC);
}
public synchronized String getGoStandbyInfo(){
return mc.getStringValue(EMcsVariables.GO_STANDBY_INFO);
}
public synchronized String getEmergencyStopInfo(){
return mc.getStringValue(EMcsVariables.EMERGENCY_STOP_INFO);
}
public synchronized String getCherenkovThControlOffInfo(){
return mc.getStringValue(EMcsVariables.CHERENKOV_TH_CONTROL_OFF_INFO);
}
public synchronized int getElRpmMax(){
return mc.getIntValue(EMcsVariables.EL_RPM_MAX);
}
public synchronized int getH4Status(){
return mc.getIntValue(EMcsVariables.H4_STATUS);
}
public synchronized int getAzMotorResolverErrorId(){
return mc.getIntValue(EMcsVariables.AZ_MOTOR_RESOLVER_ERROR_ID);
}
public synchronized boolean getDrive400vacOnOff(){
return mc.getBooleanValue(EMcsVariables.DRIVE_400VAC_ON_OFF);
}
public synchronized boolean getIsParkingElevation(){
return mc.getBooleanValue(EMcsVariables.IS_PARKING_ELEVATION);
}
public synchronized String getEnableAzMotorEncoderInfo(){
return mc.getStringValue(EMcsVariables.ENABLE_AZ_MOTOR_ENCODER_INFO);
}
public synchronized boolean getElSto(){
return mc.getBooleanValue(EMcsVariables.EL_STO);
}
public synchronized boolean getDoorHpc(){
return mc.getBooleanValue(EMcsVariables.DOOR_HPC);
}
public synchronized double getElMotorCommandedCurrent(){
return mc.getDoubleValue(EMcsVariables.EL_MOTOR_COMMANDED_CURRENT);
}
public synchronized String getSqmOnInfo(){
return mc.getStringValue(EMcsVariables.SQM_ON_INFO);
}
public synchronized String getCherenkovOffInfo(){
return mc.getStringValue(EMcsVariables.CHERENKOV_OFF_INFO);
}
public synchronized double getPh2ActivePower(){
return mc.getDoubleValue(EMcsVariables.PH2_ACTIVE_POWER);
}
public synchronized double getPh1Voltage(){
return mc.getDoubleValue(EMcsVariables.PH1_VOLTAGE);
}
public synchronized String getPcShutdownInfo(){
return mc.getStringValue(EMcsVariables.PC_SHUTDOWN_INFO);
}
public synchronized double getPh2ApparentPower(){
return mc.getDoubleValue(EMcsVariables.PH2_APPARENT_POWER);
}
public synchronized boolean getAzBrake(){
return mc.getBooleanValue(EMcsVariables.AZ_BRAKE);
}
public synchronized int getElStowpinStatus(){
return mc.getIntValue(EMcsVariables.EL_STOWPIN_STATUS);
}
public synchronized String getStopParkingInfo(){
return mc.getStringValue(EMcsVariables.STOP_PARKING_INFO);
}
public synchronized double getElMotorTemperature(){
return mc.getDoubleValue(EMcsVariables.EL_MOTOR_TEMPERATURE);
}
public synchronized boolean getIsParkingAzimuth(){
return mc.getBooleanValue(EMcsVariables.IS_PARKING_AZIMUTH);
}
public synchronized boolean getIsParkedAzimuth(){
return mc.getBooleanValue(EMcsVariables.IS_PARKED_AZIMUTH);
}
public synchronized boolean getCherenkovThControlOnOff(){
return mc.getBooleanValue(EMcsVariables.CHERENKOV_TH_CONTROL_ON_OFF);
}
public synchronized double getElCommandedAcc(){
return mc.getDoubleValue(EMcsVariables.EL_COMMANDED_ACC);
}
public synchronized double getGast(){
return mc.getDoubleValue(EMcsVariables.GAST);
}
public synchronized String getSqmOffInfo(){
return mc.getStringValue(EMcsVariables.SQM_OFF_INFO);
}
public synchronized boolean getElBrake(){
return mc.getBooleanValue(EMcsVariables.EL_BRAKE);
}
public synchronized String getResetAzAxisInfo(){
return mc.getStringValue(EMcsVariables.RESET_AZ_AXIS_INFO);
}
public synchronized int getAzStowpinStatus(){
return mc.getIntValue(EMcsVariables.AZ_STOWPIN_STATUS);
}
public synchronized int getElMotorBrakeStatus(){
return mc.getIntValue(EMcsVariables.EL_MOTOR_BRAKE_STATUS);
}
public synchronized long getNtpTime(){
return mc.getLongValue(EMcsVariables.NTP_TIME);
}
public synchronized String getStartAzEncInitInfo(){
return mc.getStringValue(EMcsVariables.START_AZ_ENC_INIT_INFO);
}
public synchronized String getPmcSqmHeaterOnInfo(){
return mc.getStringValue(EMcsVariables.PMC_SQM_HEATER_ON_INFO);
}
public synchronized String getCherenkovOnInfo(){
return mc.getStringValue(EMcsVariables.CHERENKOV_ON_INFO);
}
public synchronized double getAzMotorResolverCurrentNominal(){
return mc.getDoubleValue(EMcsVariables.AZ_MOTOR_RESOLVER_CURRENT_NOMINAL);
}
public synchronized boolean getNtpConnected(){
return mc.getBooleanValue(EMcsVariables.NTP_CONNECTED);
}
public synchronized boolean getAzLsOCw(){
return mc.getBooleanValue(EMcsVariables.AZ_LS_O_CW);
}
public synchronized int getAzStowpinError(){
return mc.getIntValue(EMcsVariables.AZ_STOWPIN_ERROR);
}
public synchronized String getSwVersion(){
return mc.getStringValue(EMcsVariables.SW_VERSION);
}
public synchronized int getElStowpinError(){
return mc.getIntValue(EMcsVariables.EL_STOWPIN_ERROR);
}
public synchronized String getGoLoadedInfo(){
return mc.getStringValue(EMcsVariables.GO_LOADED_INFO);
}
public synchronized boolean getTelescopeSwitchFault(){
return mc.getBooleanValue(EMcsVariables.TELESCOPE_SWITCH_FAULT);
}
public synchronized double getPh1Cosphi(){
return mc.getDoubleValue(EMcsVariables.PH1_COSPHI);
}
public synchronized boolean getPmcSqmHeaterOnOff(){
return mc.getBooleanValue(EMcsVariables.PMC_SQM_HEATER_ON_OFF);
}
public synchronized boolean getCircuitBreaker24vdcModules(){
return mc.getBooleanValue(EMcsVariables.CIRCUIT_BREAKER_24VDC_MODULES);
}
public synchronized double getAzMotorEncoderCommandedCurrent(){
return mc.getDoubleValue(EMcsVariables.AZ_MOTOR_ENCODER_COMMANDED_CURRENT);
}
public synchronized double getAzMotorEncoderCurrentLimit(){
return mc.getDoubleValue(EMcsVariables.AZ_MOTOR_ENCODER_CURRENT_LIMIT);
}
public synchronized double getAzMotorEncoderCurrentNominal(){
return mc.getDoubleValue(EMcsVariables.AZ_MOTOR_ENCODER_CURRENT_NOMINAL);
}
public synchronized String getStartPointingInfo(){
return mc.getStringValue(EMcsVariables.START_POINTING_INFO);
}
public synchronized int getHeartbeat(){
return mc.getIntValue(EMcsVariables.HEARTBEAT);
}
public synchronized String getUvsipmOnInfo(){
return mc.getStringValue(EMcsVariables.UVSIPM_ON_INFO);
}
public synchronized boolean getEmStopServicecab(){
return mc.getBooleanValue(EMcsVariables.EM_STOP_SERVICECAB);
}
public synchronized int getErrorBufferSize(){
return mc.getIntValue(EMcsVariables.ERROR_BUFFER_SIZE);
}
public synchronized int getAzMotorBrakeStatus(){
return mc.getIntValue(EMcsVariables.AZ_MOTOR_BRAKE_STATUS);
}
public synchronized boolean getTargetNotValid(){
return mc.getBooleanValue(EMcsVariables.TARGET_NOT_VALID);
}
public synchronized double getElActVel(){
return mc.getDoubleValue(EMcsVariables.EL_ACT_VEL);
}
public synchronized boolean getPowerSupplyRedundancyFault(){
return mc.getBooleanValue(EMcsVariables.POWER_SUPPLY_REDUNDANCY_FAULT);
}
public synchronized String getPmcSqmHeaterOffInfo(){
return mc.getStringValue(EMcsVariables.PMC_SQM_HEATER_OFF_INFO);
}
public synchronized String getAzStowOutInfo(){
return mc.getStringValue(EMcsVariables.AZ_STOW_OUT_INFO);
}
public synchronized String getStopMotionInfo(){
return mc.getStringValue(EMcsVariables.STOP_MOTION_INFO);
}
public synchronized double getAc400vFrequency(){
return mc.getDoubleValue(EMcsVariables.AC400V_FREQUENCY);
}
public synchronized double getUt1Jd(){
return mc.getDoubleValue(EMcsVariables.UT1_JD);
}
public synchronized String getElStowOutInfo(){
return mc.getStringValue(EMcsVariables.EL_STOW_OUT_INFO);
}
public synchronized double getAzMotorResolverVoltage(){
return mc.getDoubleValue(EMcsVariables.AZ_MOTOR_RESOLVER_VOLTAGE);
}
public synchronized String getSirenOffInfo(){
return mc.getStringValue(EMcsVariables.SIREN_OFF_INFO);
}
public synchronized double getAzActVel(){
return mc.getDoubleValue(EMcsVariables.AZ_ACT_VEL);
}
public synchronized boolean getRemoteLocalSelectorStatus(){
return mc.getBooleanValue(EMcsVariables.REMOTE_LOCAL_SELECTOR_STATUS);
}
public synchronized int getTcuMode(){
return mc.getIntValue(EMcsVariables.TCU_MODE);
}
public synchronized double getPh3Voltage(){
return mc.getDoubleValue(EMcsVariables.PH3_VOLTAGE);
}
public synchronized boolean getAzCcw(){
return mc.getBooleanValue(EMcsVariables.AZ_CCW);
}
public synchronized boolean getNtpSynchronized(){
return mc.getBooleanValue(EMcsVariables.NTP_SYNCHRONIZED);
}
public synchronized boolean getSurgeArresterFault(){
return mc.getBooleanValue(EMcsVariables.SURGE_ARRESTER_FAULT);
}
public synchronized String getPmcOffInfo(){
return mc.getStringValue(EMcsVariables.PMC_OFF_INFO);
}
public synchronized double getAzPointingOffset(){
return mc.getDoubleValue(EMcsVariables.AZ_POINTING_OFFSET);
}
public synchronized boolean getElStowPin(){
return mc.getBooleanValue(EMcsVariables.EL_STOW_PIN);
}
public synchronized double getPh1ActivePower(){
return mc.getDoubleValue(EMcsVariables.PH1_ACTIVE_POWER);
}
public synchronized double getAzTelPos(){
return mc.getDoubleValue(EMcsVariables.AZ_TEL_POS);
}
public synchronized boolean getAzSto(){
return mc.getBooleanValue(EMcsVariables.AZ_STO);
}
public synchronized double getAzCommandedVel(){
return mc.getDoubleValue(EMcsVariables.AZ_COMMANDED_VEL);
}
public synchronized double getAzSkyPos(){
return mc.getDoubleValue(EMcsVariables.AZ_SKY_POS);
}
public synchronized int getTrackingDurationMax(){
return mc.getIntValue(EMcsVariables.TRACKING_DURATION_MAX);
}
public synchronized double getAzMotorTelPos(){
return mc.getDoubleValue(EMcsVariables.AZ_MOTOR_TEL_POS);
}
public synchronized boolean getSirenOnOff(){
return mc.getBooleanValue(EMcsVariables.SIREN_ON_OFF);
}
public synchronized double getH2CountValue(){
return mc.getDoubleValue(EMcsVariables.H2_COUNT_VALUE);
}
public synchronized double getElMotorVoltage(){
return mc.getDoubleValue(EMcsVariables.EL_MOTOR_VOLTAGE);
}
public synchronized double getH1CountValue(){
return mc.getDoubleValue(EMcsVariables.H1_COUNT_VALUE);
}
public synchronized String getAzBrakeOnInfo(){
return mc.getStringValue(EMcsVariables.AZ_BRAKE_ON_INFO);
}
public synchronized String getSi3OffInfo(){
return mc.getStringValue(EMcsVariables.SI3_OFF_INFO);
}
public synchronized String getStopAzMotionInfo(){
return mc.getStringValue(EMcsVariables.STOP_AZ_MOTION_INFO);
}
public synchronized double getPh1ReactivePower(){
return mc.getDoubleValue(EMcsVariables.PH1_REACTIVE_POWER);
}
public synchronized String getElMotorType(){
return mc.getStringValue(EMcsVariables.EL_MOTOR_TYPE);
}
public synchronized boolean getAzStowPin(){
return mc.getBooleanValue(EMcsVariables.AZ_STOW_PIN);
}
public synchronized boolean getGateSwitch(){
return mc.getBooleanValue(EMcsVariables.GATE_SWITCH);
}
public synchronized boolean getElHigh(){
return mc.getBooleanValue(EMcsVariables.EL_HIGH);
}
public synchronized int getH1Status(){
return mc.getIntValue(EMcsVariables.H1_STATUS);
}
public synchronized String getSirenOnInfo(){
return mc.getStringValue(EMcsVariables.SIREN_ON_INFO);
}
public synchronized String getClearErrorBufferInfo(){
return mc.getStringValue(EMcsVariables.CLEAR_ERROR_BUFFER_INFO);
}
public synchronized int getH3Status(){
return mc.getIntValue(EMcsVariables.H3_STATUS);
}
public synchronized boolean getCircuitBreaker24vdcAxisDrives(){
return mc.getBooleanValue(EMcsVariables.CIRCUIT_BREAKER_24VDC_AXIS_DRIVES);
}
public synchronized boolean getCircuitBreakerCherenkov(){
return mc.getBooleanValue(EMcsVariables.CIRCUIT_BREAKER_CHERENKOV);
}
public synchronized boolean getEmStopMobilePushbutton(){
return mc.getBooleanValue(EMcsVariables.EM_STOP_MOBILE_PUSHBUTTON);
}
public synchronized boolean getSi3OnOff(){
return mc.getBooleanValue(EMcsVariables.SI3_ON_OFF);
}
public synchronized double getElActAcc(){
return mc.getDoubleValue(EMcsVariables.EL_ACT_ACC);
}
public synchronized String getElStowInInfo(){
return mc.getStringValue(EMcsVariables.EL_STOW_IN_INFO);
}
public synchronized String getUvsipmOffInfo(){
return mc.getStringValue(EMcsVariables.UVSIPM_OFF_INFO);
}
public synchronized double getAzMotorResolverTemperature(){
return mc.getDoubleValue(EMcsVariables.AZ_MOTOR_RESOLVER_TEMPERATURE);
}
public synchronized double getCabTempLpc(){
return mc.getDoubleValue(EMcsVariables.CAB_TEMP_LPC);
}
public synchronized boolean getPmcOnOff(){
return mc.getBooleanValue(EMcsVariables.PMC_ON_OFF);
}
public synchronized String getGoMaintenanceInfo(){
return mc.getStringValue(EMcsVariables.GO_MAINTENANCE_INFO);
}
public synchronized String getEnableAzMotorResolverInfo(){
return mc.getStringValue(EMcsVariables.ENABLE_AZ_MOTOR_RESOLVER_INFO);
}
public synchronized String getEnableElMotorInfo(){
return mc.getStringValue(EMcsVariables.ENABLE_EL_MOTOR_INFO);
}
public synchronized int getMachineState(){
return mc.getIntValue(EMcsVariables.MACHINE_STATE);
}
public synchronized double getPh2Current(){
return mc.getDoubleValue(EMcsVariables.PH2_CURRENT);
}
public synchronized double getPh2ReactivePower(){
return mc.getDoubleValue(EMcsVariables.PH2_REACTIVE_POWER);
}
public synchronized boolean getInitialized(){
return mc.getBooleanValue(EMcsVariables.INITIALIZED);
}
public synchronized double getAc400vTotalActivePower(){
return mc.getDoubleValue(EMcsVariables.AC400V_TOTAL_ACTIVE_POWER);
}
public synchronized int getElMotorErrorId(){
return mc.getIntValue(EMcsVariables.EL_MOTOR_ERROR_ID);
}
public synchronized double getPh2Cosphi(){
return mc.getDoubleValue(EMcsVariables.PH2_COSPHI);
}
public synchronized boolean getOverrideSafetyStatus(){
return mc.getBooleanValue(EMcsVariables.OVERRIDE_SAFETY_STATUS);
}
public synchronized String getStopPointingInfo(){
return mc.getStringValue(EMcsVariables.STOP_POINTING_INFO);
}
public synchronized double getDomePos(){
return mc.getDoubleValue(EMcsVariables.DOME_POS);
}
public synchronized double getH4CountValue(){
return mc.getDoubleValue(EMcsVariables.H4_COUNT_VALUE);
}
public synchronized int getMotionStateAzimuth(){
return mc.getIntValue(EMcsVariables.MOTION_STATE_AZIMUTH);
}
public synchronized double getElCommandedPos(){
return mc.getDoubleValue(EMcsVariables.EL_COMMANDED_POS);
}
public synchronized double getElPointingOffset(){
return mc.getDoubleValue(EMcsVariables.EL_POINTING_OFFSET);
}
public synchronized double getH3CountValue(){
return mc.getDoubleValue(EMcsVariables.H3_COUNT_VALUE);
}
public synchronized String getStopElParkingInfo(){
return mc.getStringValue(EMcsVariables.STOP_EL_PARKING_INFO);
}
public synchronized int getElMotorStatus(){
return mc.getIntValue(EMcsVariables.EL_MOTOR_STATUS);
}
public synchronized boolean getDoorLpc(){
return mc.getBooleanValue(EMcsVariables.DOOR_LPC);
}
public synchronized boolean getTargetPointed(){
return mc.getBooleanValue(EMcsVariables.TARGET_POINTED);
}
public synchronized int getAzMotorEncoderErrorId(){
return mc.getIntValue(EMcsVariables.AZ_MOTOR_ENCODER_ERROR_ID);
}
public synchronized double getPh3ReactivePower(){
return mc.getDoubleValue(EMcsVariables.PH3_REACTIVE_POWER);
}
public synchronized boolean getUvsipmOnOff(){
return mc.getBooleanValue(EMcsVariables.UVSIPM_ON_OFF);
}
public synchronized boolean getAzCw(){
return mc.getBooleanValue(EMcsVariables.AZ_CW);
}
public synchronized boolean getElLow(){
return mc.getBooleanValue(EMcsVariables.EL_LOW);
}
public synchronized String getDisableAzMotorEncoderInfo(){
return mc.getStringValue(EMcsVariables.DISABLE_AZ_MOTOR_ENCODER_INFO);
}
public synchronized String getAzStowEmergencyStopInfo(){
return mc.getStringValue(EMcsVariables.AZ_STOW_EMERGENCY_STOP_INFO);
}
public synchronized String getAzBrakeOffInfo(){
return mc.getStringValue(EMcsVariables.AZ_BRAKE_OFF_INFO);
}
public synchronized String getAzEncoderMotorType(){
return mc.getStringValue(EMcsVariables.AZ_ENCODER_MOTOR_TYPE);
}
public synchronized boolean getTargetOnTracking(){
return mc.getBooleanValue(EMcsVariables.TARGET_ON_TRACKING);
}
public synchronized boolean getCircuitBreaker24vdcM2Drive(){
return mc.getBooleanValue(EMcsVariables.CIRCUIT_BREAKER_24VDC_M2_DRIVE);
}
public synchronized boolean getSqmOnOff(){
return mc.getBooleanValue(EMcsVariables.SQM_ON_OFF);
}
public synchronized double getTtJd(){
return mc.getDoubleValue(EMcsVariables.TT_JD);
}
public synchronized String getElStowEmergencyStopInfo(){
return mc.getStringValue(EMcsVariables.EL_STOW_EMERGENCY_STOP_INFO);
}
public synchronized String getSi3OnInfo(){
return mc.getStringValue(EMcsVariables.SI3_ON_INFO);
}
public synchronized boolean getAzLyre(){
return mc.getBooleanValue(EMcsVariables.AZ_LYRE);
}
public synchronized String getStartElParkingInfo(){
return mc.getStringValue(EMcsVariables.START_EL_PARKING_INFO);
}
public synchronized String getDisableAzMotorResolverInfo(){
return mc.getStringValue(EMcsVariables.DISABLE_AZ_MOTOR_RESOLVER_INFO);
}
public synchronized String getStartTrackingInfo(){
return mc.getStringValue(EMcsVariables.START_TRACKING_INFO);
}
public synchronized boolean getIsParkedElevation(){
return mc.getBooleanValue(EMcsVariables.IS_PARKED_ELEVATION);
}
public synchronized boolean getCherenkovOnOff(){
return mc.getBooleanValue(EMcsVariables.CHERENKOV_ON_OFF);
}
public synchronized int getMachineStatePhase(){
return mc.getIntValue(EMcsVariables.MACHINE_STATE_PHASE);
}
public synchronized int getAzResolverRpmMax(){
return mc.getIntValue(EMcsVariables.AZ_RESOLVER_RPM_MAX);
}
public synchronized boolean getM2OnOff(){
return mc.getBooleanValue(EMcsVariables.M2_ON_OFF);
}
public synchronized String getEthercatSlaveStatus(){
return mc.getStringValue(EMcsVariables.ETHERCAT_SLAVE_STATUS);
}
public synchronized double getPh2Voltage(){
return mc.getDoubleValue(EMcsVariables.PH2_VOLTAGE);
}
public synchronized String getStopTrackingInfo(){
return mc.getStringValue(EMcsVariables.STOP_TRACKING_INFO);
}
public synchronized String getErrorBuffer(){
return mc.getStringValue(EMcsVariables.ERROR_BUFFER);
}
public synchronized boolean getCircuitBreaker5vdcSqm(){
return mc.getBooleanValue(EMcsVariables.CIRCUIT_BREAKER_5VDC_SQM);
}
public synchronized double getSunPosElevation(){
return mc.getDoubleValue(EMcsVariables.SUN_POS_ELEVATION);
}
public synchronized int getTrackingNodes(){
return mc.getIntValue(EMcsVariables.TRACKING_NODES);
}
public synchronized int getAzMotorEncoderStatus(){
return mc.getIntValue(EMcsVariables.AZ_MOTOR_ENCODER_STATUS);
}
public synchronized double getElCommandedVel(){
return mc.getDoubleValue(EMcsVariables.EL_COMMANDED_VEL);
}
public synchronized double getAzMotorEncoderVoltage(){
return mc.getDoubleValue(EMcsVariables.AZ_MOTOR_ENCODER_VOLTAGE);
}
public synchronized double getAzCommandedPos(){
return mc.getDoubleValue(EMcsVariables.AZ_COMMANDED_POS);
}
public synchronized double getAzMotorResolverCurrentLimit(){
return mc.getDoubleValue(EMcsVariables.AZ_MOTOR_RESOLVER_CURRENT_LIMIT);
}
public synchronized int getErrorNumber(){
return mc.getIntValue(EMcsVariables.ERROR_NUMBER);
}
public synchronized String getStartElMotionInfo(){
return mc.getStringValue(EMcsVariables.START_EL_MOTION_INFO);
}
public synchronized boolean getErrorBufferOutOfRange(){
return mc.getBooleanValue(EMcsVariables.ERROR_BUFFER_OUT_OF_RANGE);
}
public synchronized String getResetElAxisInfo(){
return mc.getStringValue(EMcsVariables.RESET_EL_AXIS_INFO);
}
public synchronized String getElBrakeOnInfo(){
return mc.getStringValue(EMcsVariables.EL_BRAKE_ON_INFO);
}
public synchronized String getM2OffInfo(){
return mc.getStringValue(EMcsVariables.M2_OFF_INFO);
}
public synchronized String getCherenkovThControlOnInfo(){
return mc.getStringValue(EMcsVariables.CHERENKOV_TH_CONTROL_ON_INFO);
}
public synchronized double getPh1ApparentPower(){
return mc.getDoubleValue(EMcsVariables.PH1_APPARENT_POWER);
}
public synchronized String getDrive400vacOnInfo(){
return mc.getStringValue(EMcsVariables.DRIVE_400VAC_ON_INFO);
}
public synchronized boolean getElLsOLow(){
return mc.getBooleanValue(EMcsVariables.EL_LS_O_LOW);
}
public synchronized String getM2OnInfo(){
return mc.getStringValue(EMcsVariables.M2_ON_INFO);
}
public synchronized double getAzActAcc(){
return mc.getDoubleValue(EMcsVariables.AZ_ACT_ACC);
}
public synchronized String getGoOnlineInfo(){
return mc.getStringValue(EMcsVariables.GO_ONLINE_INFO);
}
public synchronized String getStartAzParkingInfo(){
return mc.getStringValue(EMcsVariables.START_AZ_PARKING_INFO);
}
public synchronized String getElBrakeOffInfo(){
return mc.getStringValue(EMcsVariables.EL_BRAKE_OFF_INFO);
}
public synchronized int getTrackingNodeStep(){
return mc.getIntValue(EMcsVariables.TRACKING_NODE_STEP);
}
public synchronized boolean getSunPosDark(){
return mc.getBooleanValue(EMcsVariables.SUN_POS_DARK);
}
public synchronized int getAzEncoderRpmMax(){
return mc.getIntValue(EMcsVariables.AZ_ENCODER_RPM_MAX);
}
public synchronized String getEnableAzMotorsInfo(){
return mc.getStringValue(EMcsVariables.ENABLE_AZ_MOTORS_INFO);
}
public synchronized double getElEncOffset(){
return mc.getDoubleValue(EMcsVariables.EL_ENC_OFFSET);
}
public synchronized int getAzMotorResolverStatus(){
return mc.getIntValue(EMcsVariables.AZ_MOTOR_RESOLVER_STATUS);
}
public synchronized double getPh1Current(){
return mc.getDoubleValue(EMcsVariables.PH1_CURRENT);
}
public synchronized int getH2Status(){
return mc.getIntValue(EMcsVariables.H2_STATUS);
}
public synchronized double getTdbJd(){
return mc.getDoubleValue(EMcsVariables.TDB_JD);
}
public synchronized double getPh3ActivePower(){
return mc.getDoubleValue(EMcsVariables.PH3_ACTIVE_POWER);
}
public synchronized boolean getAzLsOCcw(){
return mc.getBooleanValue(EMcsVariables.AZ_LS_O_CCW);
}
public synchronized double getElServoCoeff1(){
	return mc.getDoubleValue(EMcsVariables.EL_SERVO_COEFF1);
}
public synchronized double getElServoCoeff2(){
	return mc.getDoubleValue(EMcsVariables.EL_SERVO_COEFF2);
}
public synchronized double getWeatherHum(){
	return mc.getDoubleValue(EMcsVariables.WEATHER_HUM);
}
public synchronized double getAzLsECwPos(){
	return mc.getDoubleValue(EMcsVariables.AZ_LS_E_CW_POS);
}
public synchronized int getTrajectoryGenerationMode(){
	return mc.getIntValue(EMcsVariables.TRAJECTORY_GENERATION_MODE);
}
public synchronized short getTargetCoordtype(){
	return mc.getShortValue(EMcsVariables.TARGET_COORDTYPE);
}
public synchronized double getAzimuthAbsoluteEncoderOffset(){
	return mc.getDoubleValue(EMcsVariables.AZIMUTH_ABSOLUTE_ENCODER_OFFSET);
}
public synchronized double getAzServoCoeff2(){
	return mc.getDoubleValue(EMcsVariables.AZ_SERVO_COEFF2);
}
public synchronized double getAzServoCoeff1(){
	return mc.getDoubleValue(EMcsVariables.AZ_SERVO_COEFF1);
}
public synchronized double getTargetPx(){
	return mc.getDoubleValue(EMcsVariables.TARGET_PX);
}
public synchronized double getElServoCoeff3(){
	return mc.getDoubleValue(EMcsVariables.EL_SERVO_COEFF3);
}
public synchronized double getAzServoCoeff3(){
	return mc.getDoubleValue(EMcsVariables.AZ_SERVO_COEFF3);
}
public synchronized double getAzTelMinPos(){
	return mc.getDoubleValue(EMcsVariables.AZ_TEL_MIN_POS);
}
public synchronized double getAzMaxDec(){
	return mc.getDoubleValue(EMcsVariables.AZ_MAX_DEC);
}
public synchronized double getElLsOLowPos(){
	return mc.getDoubleValue(EMcsVariables.EL_LS_O_LOW_POS);
}
public synchronized double getElMaxDec(){
	return mc.getDoubleValue(EMcsVariables.EL_MAX_DEC);
}
public synchronized double getTpointCoeff23(){
	return mc.getDoubleValue(EMcsVariables.TPOINT_COEFF23);
}
public synchronized double getAzLsOCwPos(){
	return mc.getDoubleValue(EMcsVariables.AZ_LS_O_CW_POS);
}
public synchronized double getTpointCoeff22(){
	return mc.getDoubleValue(EMcsVariables.TPOINT_COEFF22);
}
public synchronized double getTpointCoeff21(){
	return mc.getDoubleValue(EMcsVariables.TPOINT_COEFF21);
}
public synchronized double getTpointCoeff20(){
	return mc.getDoubleValue(EMcsVariables.TPOINT_COEFF20);
}
public synchronized double getWeatherWlen(){
	return mc.getDoubleValue(EMcsVariables.WEATHER_WLEN);
}
public synchronized double getTpointCoeff25(){
	return mc.getDoubleValue(EMcsVariables.TPOINT_COEFF25);
}
public synchronized double getTpointCoeff24(){
	return mc.getDoubleValue(EMcsVariables.TPOINT_COEFF24);
}
public synchronized double getTargetEpoch(){
	return mc.getDoubleValue(EMcsVariables.TARGET_EPOCH);
}
public synchronized double getAzLsOCcwPos(){
	return mc.getDoubleValue(EMcsVariables.AZ_LS_O_CCW_POS);
}
public synchronized double getElLsPreLowPos(){
	return mc.getDoubleValue(EMcsVariables.EL_LS_PRE_LOW_POS);
}
public synchronized double getElSkyMaxPos(){
	return mc.getDoubleValue(EMcsVariables.EL_SKY_MAX_POS);
}
public synchronized double getTpointCoeff12(){
	return mc.getDoubleValue(EMcsVariables.TPOINT_COEFF12);
}
public synchronized double getTpointCoeff11(){
	return mc.getDoubleValue(EMcsVariables.TPOINT_COEFF11);
}
public synchronized double getElSkyMinPos(){
	return mc.getDoubleValue(EMcsVariables.EL_SKY_MIN_POS);
}
public synchronized double getTpointCoeff10(){
	return mc.getDoubleValue(EMcsVariables.TPOINT_COEFF10);
}
public synchronized double getTpointCoeff16(){
	return mc.getDoubleValue(EMcsVariables.TPOINT_COEFF16);
}
public synchronized double getTpointCoeff15(){
	return mc.getDoubleValue(EMcsVariables.TPOINT_COEFF15);
}
public synchronized double getAzSlewAcceleration(){
	return mc.getDoubleValue(EMcsVariables.AZ_SLEW_ACCELERATION);
}
public synchronized double getTpointCoeff14(){
	return mc.getDoubleValue(EMcsVariables.TPOINT_COEFF14);
}
public synchronized double getTpointCoeff13(){
	return mc.getDoubleValue(EMcsVariables.TPOINT_COEFF13);
}
public synchronized double getTpointCoeff19(){
	return mc.getDoubleValue(EMcsVariables.TPOINT_COEFF19);
}
public synchronized double getTpointCoeff18(){
	return mc.getDoubleValue(EMcsVariables.TPOINT_COEFF18);
}
public synchronized double getAzSlewDeceleration(){
	return mc.getDoubleValue(EMcsVariables.AZ_SLEW_DECELERATION);
}
public synchronized double getTpointCoeff17(){
	return mc.getDoubleValue(EMcsVariables.TPOINT_COEFF17);
}
public synchronized double getTargetPmRa(){
	return mc.getDoubleValue(EMcsVariables.TARGET_PM_RA);
}
public synchronized double getAzMinAcc(){
	return mc.getDoubleValue(EMcsVariables.AZ_MIN_ACC);
}
public synchronized boolean getAzPositionTypeSky(){
	return mc.getBooleanValue(EMcsVariables.AZ_POSITION_TYPE_SKY);
}
public synchronized double getElMinDec(){
	return mc.getDoubleValue(EMcsVariables.EL_MIN_DEC);
}
public synchronized double getElLsELowPos(){
	return mc.getDoubleValue(EMcsVariables.EL_LS_E_LOW_POS);
}
public synchronized double getElTelMinPos(){
	return mc.getDoubleValue(EMcsVariables.EL_TEL_MIN_POS);
}
public synchronized double getObserverLong(){
	return mc.getDoubleValue(EMcsVariables.OBSERVER_LONG);
}
public synchronized double getElLsOHighPos(){
	return mc.getDoubleValue(EMcsVariables.EL_LS_O_HIGH_POS);
}
public synchronized boolean getParkingStowPinMode(){
	return mc.getBooleanValue(EMcsVariables.PARKING_STOW_PIN_MODE);
}
public synchronized double getElJogVelocity(){
	return mc.getDoubleValue(EMcsVariables.EL_JOG_VELOCITY);
}
public synchronized double getAzimuthIncrementalEncoderOffset(){
	return mc.getDoubleValue(EMcsVariables.AZIMUTH_INCREMENTAL_ENCODER_OFFSET);
}
public synchronized int getResetHeartbeatInterval(){
	return mc.getIntValue(EMcsVariables.RESET_HEARTBEAT_INTERVAL);
}
public synchronized double getDomePosition(){
	return mc.getDoubleValue(EMcsVariables.DOME_POSITION);
}
public synchronized double getAzTelMaxPos(){
	return mc.getDoubleValue(EMcsVariables.AZ_TEL_MAX_POS);
}
public synchronized double getOffsetAzimuth(){
	return mc.getDoubleValue(EMcsVariables.OFFSET_AZIMUTH);
}
public synchronized double getTargetPmDec(){
	return mc.getDoubleValue(EMcsVariables.TARGET_PM_DEC);
}
public synchronized double getElSkyPosition(){
	return mc.getDoubleValue(EMcsVariables.EL_SKY_POSITION);
}
public synchronized double getObserverLat(){
	return mc.getDoubleValue(EMcsVariables.OBSERVER_LAT);
}
public synchronized double getIersTaiUtc(){
	return mc.getDoubleValue(EMcsVariables.IERS_TAI_UTC);
}
public synchronized double getAzMinVel(){
	return mc.getDoubleValue(EMcsVariables.AZ_MIN_VEL);
}
public synchronized double getElLsEHighPos(){
	return mc.getDoubleValue(EMcsVariables.EL_LS_E_HIGH_POS);
}
public synchronized double getElTelPosition(){
	return mc.getDoubleValue(EMcsVariables.EL_TEL_POSITION);
}
public synchronized double getAzLsPreCwPos(){
	return mc.getDoubleValue(EMcsVariables.AZ_LS_PRE_CW_POS);
}
public synchronized double getTpointCoeff1(){
	return mc.getDoubleValue(EMcsVariables.TPOINT_COEFF1);
}
public synchronized double getWeatherWidir(){
	return mc.getDoubleValue(EMcsVariables.WEATHER_WIDIR);
}
public synchronized double getTpointCoeff3(){
	return mc.getDoubleValue(EMcsVariables.TPOINT_COEFF3);
}
public synchronized double getTpointCoeff2(){
	return mc.getDoubleValue(EMcsVariables.TPOINT_COEFF2);
}
public synchronized double getTpointCoeff5(){
	return mc.getDoubleValue(EMcsVariables.TPOINT_COEFF5);
}
public synchronized double getTpointCoeff4(){
	return mc.getDoubleValue(EMcsVariables.TPOINT_COEFF4);
}
public synchronized double getAzLsECcwPos(){
	return mc.getDoubleValue(EMcsVariables.AZ_LS_E_CCW_POS);
}
public synchronized double getTpointCoeff7(){
	return mc.getDoubleValue(EMcsVariables.TPOINT_COEFF7);
}
public synchronized double getTpointCoeff6(){
	return mc.getDoubleValue(EMcsVariables.TPOINT_COEFF6);
}
public synchronized double getTpointCoeff9(){
	return mc.getDoubleValue(EMcsVariables.TPOINT_COEFF9);
}
public synchronized int getTrackingDuration(){
	return mc.getIntValue(EMcsVariables.TRACKING_DURATION);
}
public synchronized double getTpointCoeff8(){
	return mc.getDoubleValue(EMcsVariables.TPOINT_COEFF8);
}
public synchronized double getTrackFollowingError(){
	return mc.getDoubleValue(EMcsVariables.TRACK_FOLLOWING_ERROR);
}
public synchronized int getMotionType(){
	return mc.getIntValue(EMcsVariables.MOTION_TYPE);
}
public synchronized double getElevationParkPosition(){
	return mc.getDoubleValue(EMcsVariables.ELEVATION_PARK_POSITION);
}
public synchronized double getTargetEquinox(){
	return mc.getDoubleValue(EMcsVariables.TARGET_EQUINOX);
}
public synchronized double getAzMaxVel(){
	return mc.getDoubleValue(EMcsVariables.AZ_MAX_VEL);
}
public synchronized double getWeatherTemp(){
	return mc.getDoubleValue(EMcsVariables.WEATHER_TEMP);
}
public synchronized double getElSlewDeceleration(){
	return mc.getDoubleValue(EMcsVariables.EL_SLEW_DECELERATION);
}
public synchronized double getAzMaxAcc(){
	return mc.getDoubleValue(EMcsVariables.AZ_MAX_ACC);
}
public synchronized double getElMaxAcc(){
	return mc.getDoubleValue(EMcsVariables.EL_MAX_ACC);
}
public synchronized double getIersXpp(){
	return mc.getDoubleValue(EMcsVariables.IERS_XPP);
}
public synchronized double getAzTelPosition(){
	return mc.getDoubleValue(EMcsVariables.AZ_TEL_POSITION);
}
public synchronized double getAzLsPreCcwPos(){
	return mc.getDoubleValue(EMcsVariables.AZ_LS_PRE_CCW_POS);
}
public synchronized double getIersDut1(){
	return mc.getDoubleValue(EMcsVariables.IERS_DUT1);
}
public synchronized int getTargetCoordframe(){
	return mc.getIntValue(EMcsVariables.TARGET_COORDFRAME);
}
public synchronized double getElTelMaxPos(){
	return mc.getDoubleValue(EMcsVariables.EL_TEL_MAX_POS);
}
public synchronized double getWeatherPr(){
	return mc.getDoubleValue(EMcsVariables.WEATHER_PR);
}
public synchronized String getTargetName(){
	return mc.getStringValue(EMcsVariables.TARGET_NAME);
}
public synchronized double getElMinVel(){
	return mc.getDoubleValue(EMcsVariables.EL_MIN_VEL);
}
public synchronized int getElJogDirection(){
	return mc.getIntValue(EMcsVariables.EL_JOG_DIRECTION);
}
public synchronized double getElMaxVel(){
	return mc.getDoubleValue(EMcsVariables.EL_MAX_VEL);
}
public synchronized double getOffsetElevation(){
	return mc.getDoubleValue(EMcsVariables.OFFSET_ELEVATION);
}
public synchronized double getElLsPreHighPos(){
	return mc.getDoubleValue(EMcsVariables.EL_LS_PRE_HIGH_POS);
}
public synchronized double getAzMinDec(){
	return mc.getDoubleValue(EMcsVariables.AZ_MIN_DEC);
}
public synchronized double getAzimuthParkPosition(){
	return mc.getDoubleValue(EMcsVariables.AZIMUTH_PARK_POSITION);
}
public synchronized double getAzSlewVelocity(){
	return mc.getDoubleValue(EMcsVariables.AZ_SLEW_VELOCITY);
}
public synchronized double getElMinAcc(){
	return mc.getDoubleValue(EMcsVariables.EL_MIN_ACC);
}
public synchronized double getTargetRv(){
	return mc.getDoubleValue(EMcsVariables.TARGET_RV);
}
public synchronized double getTargetDec(){
	return mc.getDoubleValue(EMcsVariables.TARGET_DEC);
}
public synchronized boolean getRefractionOnoff(){
	return mc.getBooleanValue(EMcsVariables.REFRACTION_ONOFF);
}
public synchronized double getObserverHe(){
	return mc.getDoubleValue(EMcsVariables.OBSERVER_HE);
}
public synchronized double getElevationObservationLimitMin(){
	return mc.getDoubleValue(EMcsVariables.ELEVATION_OBSERVATION_LIMIT_MIN);
}
public synchronized double getElSlewAcceleration(){
	return mc.getDoubleValue(EMcsVariables.EL_SLEW_ACCELERATION);
}
public synchronized double getIersYpp(){
	return mc.getDoubleValue(EMcsVariables.IERS_YPP);
}
public synchronized double getAzSkyPosition(){
	return mc.getDoubleValue(EMcsVariables.AZ_SKY_POSITION);
}
public synchronized boolean getPointingModelOnoff(){
	return mc.getBooleanValue(EMcsVariables.POINTING_MODEL_ONOFF);
}
public synchronized double getElevationObservationLimitMax(){
	return mc.getDoubleValue(EMcsVariables.ELEVATION_OBSERVATION_LIMIT_MAX);
}
public synchronized double getTargetRa(){
	return mc.getDoubleValue(EMcsVariables.TARGET_RA);
}
public synchronized double getElSlewVelocity(){
	return mc.getDoubleValue(EMcsVariables.EL_SLEW_VELOCITY);
}
public synchronized int getAzJogDirection(){
	return mc.getIntValue(EMcsVariables.AZ_JOG_DIRECTION);
}
public synchronized double getElevationEncoderOffset(){
	return mc.getDoubleValue(EMcsVariables.ELEVATION_ENCODER_OFFSET);
}
public synchronized double getWeatherWi(){
	return mc.getDoubleValue(EMcsVariables.WEATHER_WI);
}
public synchronized double getAzSkyMaxPos(){
	return mc.getDoubleValue(EMcsVariables.AZ_SKY_MAX_POS);
}
public synchronized double getAzimuthCounterTorque(){
	return mc.getDoubleValue(EMcsVariables.AZIMUTH_COUNTER_TORQUE);
}
public synchronized boolean getEnableSunAvoidanceWindow(){
	return mc.getBooleanValue(EMcsVariables.ENABLE_SUN_AVOIDANCE_WINDOW);
}
public synchronized double getAzSkyMinPos(){
	return mc.getDoubleValue(EMcsVariables.AZ_SKY_MIN_POS);
}
public synchronized double getAzJogVelocity(){
	return mc.getDoubleValue(EMcsVariables.AZ_JOG_VELOCITY);
}
}