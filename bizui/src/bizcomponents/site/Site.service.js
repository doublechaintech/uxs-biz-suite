import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}siteManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}siteManager/loadSite/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidatePlatform = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}siteManager/requestCandidatePlatform/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherPlatform = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}siteManager/transferToAnotherPlatform/id/anotherPlatformId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addCatalog = (targetObjectId, parameters) => {
  const url = `${PREFIX}siteManager/addCatalog/siteId/name/sellerId/platformId/tokensExpr/`
  const siteId = targetObjectId
  const requestParameters = { ...parameters, siteId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateCatalog = (targetObjectId, parameters) => {
  const url = `${PREFIX}siteManager/updateCatalogProperties/siteId/id/name/sellerId/tokensExpr/`
  const siteId = targetObjectId
  const requestParameters = { ...parameters, siteId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeCatalogList = (targetObjectId, parameters) => {
  const url = `${PREFIX}siteManager/removeCatalogList/siteId/catalogIds/tokensExpr/`
  const requestParameters = { ...parameters, siteId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const SiteService = { view,
  load,
  addCatalog,
  updateCatalog,
  removeCatalogList,
  requestCandidatePlatform,
  transferToAnotherPlatform }
export default SiteService

