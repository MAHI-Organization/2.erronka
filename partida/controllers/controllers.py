# -*- coding: utf-8 -*-
from odoo import http


class Partidak(http.Controller):

     @http.route('/partida/partida/rankingmenu', auth='public')
     def list(self, **kw):
         return http.request.render('partida.listing', {
             'root': '/partida/partida',
             'objects': http.request.env['partida.partida'].search([]),
             'langileak': http.request.env['langilea.langilea'].search([]),
         })

     @http.route('/partida/partida/langileak/<string:izena>/<int:taldea>', auth='public')
     def langilea(self, izena, taldea, **kw):
         return http.request.render('partida.partidak', {
             'taldea': taldea,
             'object': izena,
             'objects': http.request.env['partida.partida'].search([]),
             'langileak': http.request.env['langilea.langilea'].search([]),
         })

     @http.route('/partida/partida/enpresa/<int:taldezenb>', auth='public')
     def enpresa(self,taldezenb, **kw):
         return http.request.render('partida.enpresak', {
             'root' : 'partida/partida',
             'taldezenb': taldezenb,
             'langileak' : http.request.env['langilea.langilea'].search([('taldea','=',taldezenb)]),
             'objects': http.request.env['partida.partida'].search([]),
         })

     @http.route('/partida/partida/adina/<string:operator>/<string:type>', auth='public')
     def adina(self, operator,type,**kw):
         return http.request.render('partida.adina', {
             'operator' : operator,
             'type': type,
             'langileak': http.request.env['langilea.langilea'].search([('jaiotzadata', operator, '2001-01-01')]),
             'objects': http.request.env['partida.partida'].search([]),
         })

#     @http.route('/partida/partida/langileak/<model("partida.partida"):obj>', auth='public')
#     def object(self, obj, **kw):
#         return http.request.render('partida.partidak', {
#             'object': obj,
#             'objects': http.request.env['partida.partida'].search([]),
#         })
