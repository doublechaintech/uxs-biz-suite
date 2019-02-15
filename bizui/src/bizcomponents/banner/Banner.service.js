import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}bannerManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}bannerManager/loadBanner/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidatePlatform = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}bannerManager/requestCandidatePlatform/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherPlatform = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}bannerManager/transferToAnotherPlatform/id/anotherPlatformId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addTarget = (targetObjectId, parameters) => {
  const url = `${PREFIX}bannerManager/addTarget/bannerId/name/profileId/location/tokensExpr/`
  const bannerId = targetObjectId
  const requestParameters = { ...parameters, bannerId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateTarget = (targetObjectId, parameters) => {
  const url = `${PREFIX}bannerManager/updateTargetProperties/bannerId/id/name/location/tokensExpr/`
  const bannerId = targetObjectId
  const requestParameters = { ...parameters, bannerId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeTargetList = (targetObjectId, parameters) => {
  const url = `${PREFIX}bannerManager/removeTargetList/bannerId/targetIds/tokensExpr/`
  const requestParameters = { ...parameters, bannerId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const BannerService = { view,
  load,
  addTarget,
  updateTarget,
  removeTargetList,
  requestCandidatePlatform,
  transferToAnotherPlatform }
export default BannerService

