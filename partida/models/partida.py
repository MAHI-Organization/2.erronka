# -*- coding: utf-8 -*-

from odoo import models, fields, api

class partida(models.Model):
    _name = 'partida.partida'
    _log_access = False

    data = fields.Date()
    puntuazioa = fields.Integer()
    erabiltzailea_id = fields.Many2one('langilea.langilea',string='Erabiltzailea Id')
    erabiltzailea_name = fields.Char(string='Erabiltzailea',related='erabiltzailea_id.erabiltzailea',store=True)
    ##erabiltzailea_name = fields.Char(string='Erabiltzailea Izena',related='erabiltzailea.erabiltzailea')

#    @api.model
#    def create(self, vals):
#        record = super(partida,self).create(vals)
#        if record.erabiltzailea_id:
#            record.erabiltzailea_name = record.erabiltzailea_id.erabiltzailea
#        return record

#    @api.model
#    def write(self, vals):
#        res = super(partida, self).write(vals)
#        for record in self:
#            if record.erabiltzailea_id:
#                record.erabiltzailea_name = record.erabiltzailea_id.erabiltzailea
#        return record
# class partida(models.Model):
#     _name = 'partida.partida'
#     _description = 'partida.partida'

#     name = fields.Char()
#     value = fields.Integer()
#     value2 = fields.Float(compute="_value_pc", store=True)
#     description = fields.Text()
#
#     @api.depends('value')
#     def _value_pc(self):
#         for record in self:
#             record.value2 = float(record.value) / 100
