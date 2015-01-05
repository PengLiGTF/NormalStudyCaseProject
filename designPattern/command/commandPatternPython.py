#!/usr/bin/env python
class Switch(object):
    def execute(cls,command):
        command.execute()

class Command(object):
    def __init__(self,obj):
        self._obj=obj
    
    def execute(self):
        raise NotImplemented

class TurnOnCommand(Command):
    def execute(self):
        self._obj.turn_on()

class TurnOffCommand(Command):
    def execute(self):
        self._obj.turn_off()

class Light(object):
    def turn_on(self):
        print("the light is on")

    def turn_off(self):
        print("the light is off")

class LightSwitchClient(object):
    def __init__(self):
        self._lamp=Light()
        self._switch=Switch()

    def switch(self,cmd):
        cmd=cmd.strip().upper()
        if cmd=="ON":
            self._switch.execute(TurnOnCommand(self._lamp))
        elif cmd=="OFF":
            self._switch.execute(TurnOffCommand(self._lamp))
        else:
            print("argument 'on' of 'off' is required")

if __name__=="__main__":
    light_switch = LightSwitchClient()
    print("switch on test")
    light_switch.switch("ON")
    print("switch off test")
    light_switch.switch("OFF")


